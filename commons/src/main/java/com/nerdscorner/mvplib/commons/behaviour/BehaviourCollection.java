package com.nerdscorner.mvplib.commons.behaviour;

import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Public interface denoting a collection of behaviours. This extends {@link Iterable<Behaviour>}
 * as it is a collection and can be iterated.
 */
public interface BehaviourCollection extends Iterable<Behaviour> {

    /**
     * Add an element to the collection. The collection should contain unique behaviours (were
     * comparisons are made in class level, meaning that only one behaviour instance per class
     * will exist in a collection).
     *
     * If theres already a behaviour present for a class, the already present will remain, and
     * the current add will be discarded / stubbed.
     *
     * @param behaviour to add
     * @return true if it was added, false otherwise
     */
    @CheckResult
    boolean add(@NonNull final Behaviour behaviour);

    /**
     * Remove a behaviour from the collection.
     *
     * Note that if the collection contains a behaviour for a given class, but its not the one
     * provided, it <b>won't</b> remove it.
     *
     * @param behaviour to find and remove
     * @return true if it was removed, false otherwise
     */
    @CheckResult
    boolean remove(@NonNull final Behaviour behaviour);

    /**
     * Get a behaviour for the given class type if existent.
     *
     * @param type of behaviour to look for
     * @param <T> behaviour class
     * @return instance of the behaviour class provided, null if there was none
     */
    @Nullable
    <T extends Behaviour> T get(@NonNull final Class<T> type);

}
