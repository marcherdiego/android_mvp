package com.nerdscorner.mvplib.events.config.annotations

import androidx.annotation.IntDef
import com.nerdscorner.mvplib.events.config.annotations.RegisterAt.Companion.ON_CREATE
import com.nerdscorner.mvplib.events.config.annotations.RegisterAt.Companion.ON_RESUME
import com.nerdscorner.mvplib.events.config.annotations.RegisterAt.Companion.ON_START

@IntDef(ON_CREATE, ON_START, ON_RESUME)
@Retention(AnnotationRetention.SOURCE)
annotation class RegisterAt {
    companion object {
        const val ON_CREATE = 1
        const val ON_START = 2
        const val ON_RESUME = 3
    }
}
