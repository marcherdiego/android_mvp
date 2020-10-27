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

    @Deprecated(
            message = "Deprecated in favor of using Presenter's lifecycle functions",
            replaceWith = ReplaceWith("presenter.onResume()")
    )
    open fun onResume() {
    }

    @Deprecated(
            message = "Deprecated in favor of using Presenter's lifecycle functions",
            replaceWith = ReplaceWith("presenter.onPause()")
    )
    open fun onPause() {
    }

    @Deprecated(
            message = "Deprecated in favor of using Presenter's lifecycle functions",
            replaceWith = ReplaceWith("presenter.onStart()")
    )
    open fun onStart() {
    }

    @Deprecated(
            message = "Deprecated in favor of using Presenter's lifecycle functions",
            replaceWith = ReplaceWith("presenter.onStop()")
    )
    open fun onStop() {
    }

    @Deprecated(
            message = "Deprecated in favor of using Presenter's lifecycle functions",
            replaceWith = ReplaceWith("presenter.onDestroy()")
    )
    open fun onDestroy() {
    }

    @Deprecated(
            message = "Deprecated in favor of using Presenter's lifecycle functions",
            replaceWith = ReplaceWith("presenter.onDestroyView()")
    )
    open fun onDestroyView() {
    }
}
