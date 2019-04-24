package com.nerdscorner.mvplib.events.config

import androidx.annotation.IntDef
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt.Companion.ON_CREATE
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt.Companion.ON_RESUME
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt.Companion.ON_START
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt.Companion.ON_DESTROY
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt.Companion.ON_PAUSE
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt.Companion.ON_STOP

object MvpConfig {

    @RegisterAt
    var registerAt: Int = ON_RESUME

    @UnregisterAt
    var unregisterAt: Int = ON_PAUSE

    fun initWith(@RegisterAt registerAt: Int, @UnregisterAt unregisterAt: Int) {
        MvpConfig.registerAt = registerAt
        MvpConfig.unregisterAt = unregisterAt
    }

    @IntDef(ON_CREATE, ON_START, ON_RESUME)
    @Retention(AnnotationRetention.SOURCE)
    annotation class RegisterAt {
        companion object {
            const val ON_CREATE = 1
            const val ON_START = 2
            const val ON_RESUME = 3
        }
    }

    @IntDef(ON_DESTROY, ON_STOP, ON_PAUSE)
    @Retention(AnnotationRetention.SOURCE)
    annotation class UnregisterAt {
        companion object {
            const val ON_DESTROY = 1
            const val ON_STOP = 2
            const val ON_PAUSE = 3
        }
    }
}
