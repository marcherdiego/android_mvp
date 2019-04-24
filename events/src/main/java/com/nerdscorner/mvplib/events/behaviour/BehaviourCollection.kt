package com.nerdscorner.mvplib.events.behaviour

import androidx.annotation.CheckResult

/**
 * Public interface denoting a collection of behaviours. This extends [<]
 * as it is a collection and can be iterated.
 */
interface BehaviourCollection : Iterable<Behaviour> {

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
    fun add(behaviour: Behaviour): Boolean

    /**
     * Remove a behaviour from the collection.
     *
     * Note that if the collection contains a behaviour for a given class, but its not the one
     * provided, it **won't** remove it.
     *
     * @param behaviour to find and remove
     * @return true if it was removed, false otherwise
     */
    @CheckResult
    fun remove(behaviour: Behaviour): Boolean

    /**
     * Get a behaviour for the given class type if existent.
     *
     * @param type of behaviour to look for
     * @param <T> behaviour class
     * @return instance of the behaviour class provided, null if there was none
    </T> */
    operator fun <T : Behaviour> get(type: Class<T>): T?

}
