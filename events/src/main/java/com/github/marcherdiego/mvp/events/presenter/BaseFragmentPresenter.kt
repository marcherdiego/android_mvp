package com.github.marcherdiego.mvp.events.presenter

import android.os.Bundle
import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.model.BaseEventsModel
import com.github.marcherdiego.mvp.events.view.BaseFragmentView

open class BaseFragmentPresenter<V : BaseFragmentView, M : BaseEventsModel>
@JvmOverloads constructor(view: V, model: M, internal var bus: Bus = Bus.defaultBus) : BasePresenter<V, M>(view, model) {

    init {
        view.setBus(bus)
        model.setBus(bus)
    }

    open fun onViewStateRestored(savedInstanceState: Bundle?) {}
}
