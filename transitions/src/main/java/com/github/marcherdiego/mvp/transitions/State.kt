package com.github.marcherdiego.mvp.transitions

import android.content.Context

data class State(val id: Int = autoIncrement++) {
    private val transitions = mutableMapOf<Event, Transition>()

    fun applyTransitionForEvent(context: Context?, event: Event): State? {
        val transition = transitions[event] ?: return null
        context?.let {
            transition.sideEffect(it)
        }
        return transition.target
    }

    fun addTransition(toState: State?, event: Event, sideEffect: (context: Context) -> Unit) {
        transitions[event] = Transition(toState, sideEffect)
    }
    
    companion object {
        private var autoIncrement = 0
    }
}
