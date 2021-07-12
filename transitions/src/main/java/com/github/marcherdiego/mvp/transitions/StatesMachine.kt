package com.github.marcherdiego.mvp.transitions

import android.content.Context
import com.github.marcherdiego.mvp.transitions.extensions.addIfNotPresent

open class StatesMachine @JvmOverloads constructor(
    val states: MutableList<State?> = mutableListOf(),
    var currentState: State? = null
) {

    private var onEndListener: (() -> Unit) = {}

    fun onEvent(context: Context?, event: Event) {
        currentState = currentState?.applyTransitionForEvent(context, event)
        if (currentState == null) {
            onEndListener()
        }
    }

    fun setOnEndListener(listener: () -> Unit) {
        onEndListener = listener
    }

    fun addState(state: State) {
        states.add(state)
    }

    fun addTransition(fromState: State, toState: State?, onEvent: Event, sideEffect: Context.() -> Unit = {}) {
        fromState.addTransition(toState, onEvent, sideEffect)
        states.addIfNotPresent(fromState)
        states.addIfNotPresent(toState)
    }
    
    fun applyTransition(context: Context?, transition: Transition): State? {
        context?.let {
            transition.sideEffect(it)
        }
        currentState = transition.target
        return currentState
    }
}
