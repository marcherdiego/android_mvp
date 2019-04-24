package com.nerdscorner.mvplib.events.behaviour

import android.util.Log
import androidx.annotation.CheckResult
import androidx.collection.ArraySet

/**
 * Class for setting required behaviours to be used during the app lifecycle
 */
class RequiredBehaviours

/**
 * Private constructor which will throw an exception if used.
 * @throws IllegalAccessException thrown if tried to be called somehow
 */
@Throws(IllegalAccessException::class)
private constructor() {

    init {
        throw IllegalAccessException("This cant be instantiated")
    }

    companion object {
        private val TAG = RequiredBehaviours::class.java.simpleName

        private const val INSTANTIATE_ERROR_MESSAGE = "Can't instantiate behaviour: %s, feature won't be enabled. Error: %s"

        private var behaviours: Collection<Class<out Behaviour>>? = null

        /**
         * Set behaviours as required, note that only one per class will be used, so its futile to
         * add duplicates
         * @param behaviours to set
         */
        fun set(behaviours: Collection<Class<out Behaviour>>) {
            Companion.behaviours = behaviours
        }

        /**
         * Check if the behaviour class is present or not in the required behaviours
         * @param clazz to check if exists
         * @return true if its present, false otherwise
         */
        /* default */ internal operator fun contains(clazz: Class<out Behaviour>): Boolean {
            return behaviours != null && behaviours?.contains(clazz) == true
        }

        /**
         * Create a collection of instances of the current required behaviours. Note that only one
         * behaviour instance per class will be contained (the first one to be iterated on)
         *
         * @return distinct behaviours instance of the required ones.
         */
        @CheckResult
        internal/* default */ fun create(): Collection<Behaviour> {
            val classes = behaviours
            val behaviours = ArraySet<Behaviour>()
            if (classes != null) {
                for (each in classes) {
                    try {
                        behaviours.add(each.newInstance())
                    } catch (e: InstantiationException) {
                        Log.e(TAG, INSTANTIATE_ERROR_MESSAGE, e)
                    } catch (e: IllegalAccessException) {
                        Log.e(TAG, INSTANTIATE_ERROR_MESSAGE, e)
                    }

                }
            }
            return behaviours
        }
    }
}
