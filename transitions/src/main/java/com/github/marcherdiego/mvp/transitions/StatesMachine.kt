package com.github.marcherdiego.mvp.transitions

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.github.marcherdiego.mvp.transitions.domain.Event
import com.github.marcherdiego.mvp.transitions.domain.State
import com.github.marcherdiego.mvp.transitions.domain.Transition
import com.github.marcherdiego.mvp.transitions.extensions.addIfNotPresent

open class StatesMachine @JvmOverloads constructor(val states: MutableList<State?> = mutableListOf(), var currentState: State? = null) {

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

    fun addActivityTransition(fromState: State, toState: State?, onEvent: Event, sideEffect: AppCompatActivity.() -> Unit = {}) {
        fromState.addActivityTransition(toState, onEvent, sideEffect)
        states.addIfNotPresent(fromState)
        states.addIfNotPresent(toState)
    }

    fun addFragmentTransition(fromState: State, toState: State?, onEvent: Event, sideEffect: FragmentManager.() -> Unit = {}) {
        fromState.addFragmentTransition(toState, onEvent, sideEffect)
        states.addIfNotPresent(fromState)
        states.addIfNotPresent(toState)
    }

    fun applyTransition(context: Context?, transition: Transition): State? {
        transition.runSideEffect(context)
        currentState = transition.target
        return currentState
    }
}
