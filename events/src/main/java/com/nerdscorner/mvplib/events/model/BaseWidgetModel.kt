package com.nerdscorner.mvplib.events.model

import com.nerdscorner.mvplib.events.bus.Bus

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

    fun post(event: Any) {
        bus.post(event)
    }
}
