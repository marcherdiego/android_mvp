package com.nerdscorner.mvplib.events.model

import com.nerdscorner.mvplib.events.bus.Bus
import org.greenrobot.eventbus.ThreadMode

open class BaseWidgetModel(@JvmField var bus: Bus = Bus.defaultBus) {

    @JvmName("setBusValue")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    @JvmName("getBusValue")
    fun getBus() = bus

    fun removeStickyEvent(event: Any) {
        bus.removeStickyEvent(event)
    }

    fun post(event: Any, threadMode: ThreadMode = ThreadMode.POSTING) {
        bus.post(event, threadMode)
    }

    fun postSticky(event: Any) {
        bus.postSticky(event)
    }

    fun postDefault(event: Any, threadMode: ThreadMode = ThreadMode.POSTING) {
        Bus.postDefault(event, threadMode)
    }

    fun postStickyDefault(event: Any) {
        Bus.postStickyDefault(event)
    }
}
