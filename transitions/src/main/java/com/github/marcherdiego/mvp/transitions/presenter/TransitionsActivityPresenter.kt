package com.github.marcherdiego.mvp.transitions.presenter

import com.github.marcherdiego.mvp.transitions.domain.Event
import com.github.marcherdiego.mvp.transitions.domain.State
import com.github.marcherdiego.mvp.transitions.StatesMachine
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import com.nerdscorner.mvplib.events.view.BaseActivityView

abstract class TransitionsActivityPresenter<V : BaseActivityView, M : BaseEventsModel> @JvmOverloads constructor(
    view: V,
    model: M,
    private var state: State,
    private var statesMachine: StatesMachine,
    bus: Bus = Bus.defaultBus
) : BaseActivityPresenter<V, M>(view, model, bus) {

    override fun onResume() {
        super.onResume()
        statesMachine.currentState = state
    }
    
    fun onEvent(event: Event) {
        statesMachine.onEvent(view.activity, event)
    }
}
