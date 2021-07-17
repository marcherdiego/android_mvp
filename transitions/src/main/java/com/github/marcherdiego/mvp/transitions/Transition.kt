package com.github.marcherdiego.mvp.transitions

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager

open class Transition(
    val target: State?,
    val sideEffect: ((context: Context) -> Unit) = {}
) {
    open fun runSideEffect(context: Context?) {
        if (context != null) {
            sideEffect(context)
        }
    }
}
