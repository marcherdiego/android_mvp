package com.github.marcherdiego.mvp.transitions.domain

import android.content.Context
import androidx.fragment.app.FragmentManager

class FragmentTransition(target: State?, val fragmentSideEffect: ((fragmentManager: FragmentManager) -> Unit) = {}) : Transition(target) {
    override fun runSideEffect(context: Context?) {
        if (context is FragmentManager) {
            fragmentSideEffect(context)
        }
    }
}
