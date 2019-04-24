package com.nerdscorner.mvplib.events.behaviour

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CheckResult
import androidx.annotation.RequiresApi
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import java.util.HashMap
import java.util.Spliterator
import java.util.function.Consumer

/**
 * Manager of behaviours.
 * This class is in charge of storing, attaching and notifying behaviours of a context lifecycle.
 */
@RestrictTo(RestrictTo.Scope.LIBRARY)
class BehaviourManager : ComponentsCallback, Attachable, BehaviourCollection {

    /**
     * The list of total behaviours containing both required and optional ones for each.
     * Note that there will only exist one behaviour instance for each class
     */
    private val behaviours: MutableMap<Class<out Behaviour>, Behaviour>

    /**
     * Create this manager with all required behaviours.
     */
    init {
        behaviours = HashMap()
        for (behaviour in RequiredBehaviours.create()) {
            if (!behaviours.containsKey(behaviour.javaClass)) {
                behaviours[behaviour.javaClass] = behaviour
            }
        }
    }

    /**
     * Attach a context of an [AppCompatActivity] to the manager's behaviours.
     * @param activity the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun attach(activity: AppCompatActivity) {
        attachInternal(activity)
    }

    /**
     * Attach a context of an [Fragment] to the manager's behaviours.
     * @param fragment the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun attach(fragment: Fragment) {
        attachInternal(fragment)
    }

    /**
     * Internal attach process, where we do nasty things we are not proud of at least until
     * we decide how to decouple the different Contexts from the behaviours
     *
     * @param object to attach to all our behaviours
     */
    private fun attachInternal(`object`: Any) {
        var type = TYPE_NOT_FOUND
        if (`object` is Fragment) {
            type = TYPE_FRAGMENT
        } else if (`object` is AppCompatActivity) {
            type = TYPE_ACTIVITY
        }

        if (type == TYPE_NOT_FOUND) {
            return
        }

        for (behaviour in behaviours.values) {
            if (type == TYPE_FRAGMENT) {
                behaviour.attach(`object` as Fragment)
            } else {
                behaviour.attach(`object` as AppCompatActivity)
            }
        }
    }

    /**
     * @inheritDoc
     */
    @CheckResult
    override fun add(behaviour: Behaviour): Boolean {
        if (behaviours.containsKey(behaviour.javaClass)) {
            return false
        }
        behaviours[behaviour.javaClass] = behaviour
        return true
    }

    /**
     * Note that if the behaviour is a required one, it wont be removed.
     * @inheritDoc
     */
    @CheckResult
    override fun remove(behaviour: Behaviour): Boolean {
        if (behaviours[behaviour.javaClass] === behaviour && !RequiredBehaviours.contains(behaviour.javaClass)) {
            behaviours.remove(behaviour.javaClass)
            return true
        }
        return false
    }

    /**
     * @inheritDoc
     */
    override fun <T : Behaviour> get(type: Class<T>): T? {
        return behaviours[type] as T?
    }

    /**
     * @inheritDoc
     */
    override fun iterator(): Iterator<Behaviour> {
        return behaviours.values.iterator()
    }

    /**
     * @inheritDoc
     */
    @RequiresApi(Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    override fun forEach(action: Consumer<in Behaviour>) {
        behaviours.values.forEach(action)
    }

    /**
     * @inheritDoc
     */
    @RequiresApi(Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    override fun spliterator(): Spliterator<Behaviour> {
        return behaviours.values.spliterator()
    }

    /**
     * @inheritDoc
     */
    @CheckResult
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun attachBaseContext(context: Context): Context {
        var finalContext = context
        for (behaviour in behaviours.values) {
            finalContext = behaviour.attachBaseContext(finalContext)
        }
        return finalContext
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onCreate(saveInstanceState: Bundle?) {
        for (behaviour in behaviours.values) {
            behaviour.onCreate(saveInstanceState)
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onDestroy() {
        for (behaviour in behaviours.values) {
            behaviour.onDestroy()
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onStart() {
        for (behaviour in behaviours.values) {
            behaviour.onStart()
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onStop() {
        for (behaviour in behaviours.values) {
            behaviour.onStop()
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onResume() {
        for (behaviour in behaviours.values) {
            behaviour.onResume()
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onAttach(context: Context?) {
        for (behaviour in behaviours.values) {
            behaviour.onAttach(context)
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onDetach() {
        for (behaviour in behaviours.values) {
            behaviour.onDetach()
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onPostCreate(savedInstanceState: Bundle?) {
        for (behaviour in behaviours.values) {
            behaviour.onPostCreate(savedInstanceState)
        }
    }

    /**
     * @inheritDoc
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        for (behaviour in behaviours.values) {
            behaviour.onActivityResult(requestCode, resultCode, data)
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onPause() {
        for (behaviour in behaviours.values) {
            behaviour.onPause()
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var result = false
        for (behaviour in behaviours.values) {
            if (behaviour.onOptionsItemSelected(item)) {
                result = true
            }
        }
        return result
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onPrepareOptionsMenu(item: Menu): Boolean {
        var result = true
        for (behaviour in behaviours.values) {
            result = result and behaviour.onPrepareOptionsMenu(item)
        }
        return result
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onBackPressed(): Boolean {
        var result = false
        for (behaviour in behaviours.values) {
            if (behaviour.onBackPressed()) {
                result = true
            }
        }
        return result
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onConfigurationChanged(newConfig: Configuration) {
        for (behaviour in behaviours.values) {
            behaviour.onConfigurationChanged(newConfig)
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onSaveInstanceState(outState: Bundle) {
        for (behaviour in behaviours.values) {
            behaviour.onSaveInstanceState(outState)
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        for (behaviour in behaviours.values) {
            behaviour.onRestoreInstanceState(savedInstanceState)
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        for (behaviour in behaviours.values) {
            behaviour.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }


    /**
     * @inheritDoc
     */
    @CheckResult
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun <Component> getComponent(componentClass: Class<Component>): Component? {
        for (behaviour in behaviours.values) {
            val component = behaviour.getComponent(componentClass)
            if (component != null) {
                return component
            }
        }
        return null
    }

    /**
     * @inheritDoc
     */
    @CheckResult
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun setContentView(view: View, params: ViewGroup.LayoutParams?): View {
        var finalView = view
        for (behaviour in behaviours.values) {
            finalView = behaviour.setContentView(finalView, params)
        }
        return finalView
    }

    companion object {
        private const val TYPE_NOT_FOUND = -1
        private const val TYPE_FRAGMENT = 0
        private const val TYPE_ACTIVITY = 1
    }
}