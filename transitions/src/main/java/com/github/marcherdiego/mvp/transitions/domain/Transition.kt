package com.github.marcherdiego.mvp.transitions.domain

import android.content.Context

open class Transition(val target: State?, val sideEffect: ((context: Context) -> Unit) = {}) {
    open fun runSideEffect(context: Context?) {
        if (context != null) {
            sideEffect(context)
        }
    }
}
