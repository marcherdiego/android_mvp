package com.nerdscorner.mvplib.events.presenter

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import com.nerdscorner.mvplib.commons.mvp.presenter.BasePresenter
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.events.view.BaseFragmentView

open class BaseFragmentPresenter<V : BaseFragmentView, M : BaseEventsModel>
@JvmOverloads constructor(view: V, model: M, var bus: Bus = Bus.defaultEventBus) :
        BasePresenter<V, M>(view, model) {

    init {
        view.bus = bus
        model.bus = bus
    }

    fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {}

    fun onViewStateRestored(savedInstanceState: Bundle?) {}
}
