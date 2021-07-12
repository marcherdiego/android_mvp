package com.github.marcherdiego.mvp.transitions

import android.content.Context

data class Transition(val target: State?, val sideEffect: (context: Context) -> Unit)
