package com.nerdscorner.mvplib.commons.behaviour;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.ArraySet;
import android.util.Log;

import java.util.Collection;

/**
 * Class for setting required behaviours to be used during the app lifecycle
 */
public final class RequiredBehaviours {
    private static final String TAG = RequiredBehaviours.class.getSimpleName();

    @NonNull
    private static final String INSTANTIATE_ERROR_MESSAGE = "Can't instantiate behaviour: %s, feature won't be enabled. Error: %s";

    @Nullable
    private static Collection<Class<? extends Behaviour>> behaviours;

    /**
     * Private constructor which will throw an exception if used.
     * @throws IllegalAccessException thrown if tried to be called somehow
     */
    private RequiredBehaviours() throws IllegalAccessException {
        throw new IllegalAccessException("This cant be instantiated");
    }

    /**
     * Set behaviours as required, note that only one per class will be used, so its futile to
     * add duplicates
     * @param behaviours to set
     */
    public static void set(@NonNull final Collection<Class<? extends Behaviour>> behaviours) {
        RequiredBehaviours.behaviours = behaviours;
    }

    /**
     * Check if the behaviour class is present or not in the required behaviours
     * @param clazz to check if exists
     * @return true if its present, false otherwise
     */
    /* default */ static boolean contains(@NonNull final Class<? extends Behaviour> clazz) {
        return behaviours != null && behaviours.contains(clazz);
    }

    /**
     * Create a collection of instances of the current required behaviours. Note that only one
     * behaviour instance per class will be contained (the first one to be iterated on)
     *
     * @return distinct behaviours instance of the required ones.
     */
    @NonNull
    @CheckResult
    /* default */ static Collection<Behaviour> create() {
        final Collection<Class<? extends Behaviour>> classes = RequiredBehaviours.behaviours;
        final Collection<Behaviour> behaviours = new ArraySet<>();
        if (classes != null) {
            for (Class<? extends Behaviour> each : classes) {
                try {
                    behaviours.add(each.newInstance());
                } catch (InstantiationException e) {
                    Log.e(TAG, INSTANTIATE_ERROR_MESSAGE, e);
                } catch (IllegalAccessException e) {
                    Log.e(TAG, INSTANTIATE_ERROR_MESSAGE, e);
                }
            }
        }
        return behaviours;
    }
}
