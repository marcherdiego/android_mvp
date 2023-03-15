package com.github.marcherdiego.mvp.events.config.annotations

import androidx.annotation.IntDef
import com.github.marcherdiego.mvp.events.config.annotations.UnregisterAt.Companion.ON_DESTROY
import com.github.marcherdiego.mvp.events.config.annotations.UnregisterAt.Companion.ON_PAUSE
import com.github.marcherdiego.mvp.events.config.annotations.UnregisterAt.Companion.ON_STOP

@IntDef(ON_DESTROY, ON_STOP, ON_PAUSE)
@Retention(AnnotationRetention.SOURCE)
annotation class UnregisterAt {
    companion object {
        const val ON_DESTROY = 1
        const val ON_STOP = 2
        const val ON_PAUSE = 3
    }
}
