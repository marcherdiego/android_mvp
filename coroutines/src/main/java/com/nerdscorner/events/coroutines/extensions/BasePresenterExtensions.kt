package com.nerdscorner.events.coroutines.extensions

import com.nerdscorner.mvplib.events.presenter.BasePresenter
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun BasePresenter<*, *>.postDelayed(delayTime: Long, block: () -> Unit) {
    GlobalScope.launch {
        delay(delayTime)
        block()
    }
}
