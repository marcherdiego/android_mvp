package com.github.marcherdiego.mvp.transitions.domain

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

data class State(val id: Int = autoIncrement++) {
    private val transitions = mutableMapOf<Event, Transition>()

    fun applyTransitionForEvent(context: Context?, event: Event): State? {
        val transition = transitions[event] ?: return null
        transition.runSideEffect(context)
        return transition.target
    }

    fun addTransition(toState: State?, event: Event, sideEffect: (context: Context) -> Unit) {
        transitions[event] = Transition(toState, sideEffect)
    }

    fun addActivityTransition(toState: State?, event: Event, sideEffect: AppCompatActivity.() -> Unit) {
        transitions[event] = ActivityTransition(toState, sideEffect)
    }

    fun addFragmentTransition(toState: State?, event: Event, sideEffect: FragmentManager.() -> Unit) {
        transitions[event] = FragmentTransition(toState, sideEffect)
    }

    companion object {
        private var autoIncrement = 0
    }
}
