package com.nerdscorner.mvplib.events.model

import com.nerdscorner.mvplib.events.bus.Bus

open class BaseWidgetModel {

    @JvmField
    protected var bus: Bus

    constructor() {
        bus = Bus.defaultBus
    }

    constructor(bus: Bus) {
        this.bus = bus
    }

    @JvmName("setBusValue")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    @JvmName("getBusValue")
    fun getBus() = bus

    fun removeStickyEvent(event: Any) {
        bus.removeStickyEvent(event)
    }
}