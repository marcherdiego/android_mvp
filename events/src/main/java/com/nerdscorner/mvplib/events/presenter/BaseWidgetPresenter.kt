package com.nerdscorner.mvplib.events.presenter

import androidx.annotation.CallSuper
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseWidgetModel
import com.nerdscorner.mvplib.events.view.BaseWidgetView

open class BaseWidgetPresenter<V : BaseWidgetView, M : BaseWidgetModel>
@JvmOverloads constructor(
        @JvmField var view: V,
        @JvmField var model: M,
        internal var bus: Bus = Bus.defaultBus
) {
    init {
        view.setBus(bus)
        model.setBus(bus)
    }

    @CallSuper
    open fun onAttached() {
        bus.register(this)
    }

    @CallSuper
    open fun onDetached() {
        bus.unregister(this)
    }

    fun removeStickyEvent(event: Any) {
        bus.removeStickyEvent(event)
    }

    fun removeStickyDefaultEvent(event: Any) {
        Bus.defaultBus.removeStickyEvent(event)
    }
}
