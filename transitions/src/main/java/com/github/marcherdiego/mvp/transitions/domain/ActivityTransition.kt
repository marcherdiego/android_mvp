package com.github.marcherdiego.mvp.transitions.domain

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class ActivityTransition(target: State?, val activitySideEffect: ((activity: AppCompatActivity) -> Unit) = {}) : Transition(target) {
    override fun runSideEffect(context: Context?) {
        if (context is AppCompatActivity) {
            activitySideEffect(context)
        }
    }
}
