package com.github.marcherdiego.mvp.events.presenter

import androidx.annotation.CallSuper
import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.model.BaseWidgetModel
import com.github.marcherdiego.mvp.events.view.BaseWidgetView

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
