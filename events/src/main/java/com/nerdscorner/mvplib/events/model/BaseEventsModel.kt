package com.nerdscorner.mvplib.events.model

import com.nerdscorner.mvplib.events.bus.Bus

open class BaseEventsModel {

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

    open fun onResume() {}

    open fun onPause() {}

    open fun onStart() {}

    open fun onStop() {}

    open fun onDestroy() {}

    open fun onDestroyView() {}
}
