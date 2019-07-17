package com.nerdscorner.mvplib.events.presenter

import android.os.Bundle
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.events.view.BaseFragmentView

open class BaseFragmentPresenter<V : BaseFragmentView, M : BaseEventsModel>
@JvmOverloads constructor(view: V, model: M, internal var bus: Bus = Bus.defaultBus) : BasePresenter<V, M>(view, model) {

    init {
        view.setBus(bus)
        model.setBus(bus)
    }

    fun onViewStateRestored(savedInstanceState: Bundle?) {}
}
