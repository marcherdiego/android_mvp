package com.github.marcherdiego.mvp.coroutines.extensions

import com.github.marcherdiego.mvp.events.presenter.BasePresenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun BasePresenter<*, *>.postDelayed(delayTime: Long, block: () -> Unit) {
    GlobalScope.launch {
        delay(delayTime)
        model.launchMain {
            block()
        }
    }
}
