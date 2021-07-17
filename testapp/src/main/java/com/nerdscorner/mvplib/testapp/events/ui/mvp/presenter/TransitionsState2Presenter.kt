package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter

import com.github.marcherdiego.mvp.transitions.presenter.TransitionsActivityPresenter
import com.nerdscorner.mvplib.testapp.events.statesmachine.AppStatesMachine

import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.TransitionsState2Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState2View
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState2View.Transition3ButtonClickedEvent
import org.greenrobot.eventbus.Subscribe

class TransitionsState2Presenter(view: TransitionsState2View, model: TransitionsState2Model) :
    TransitionsActivityPresenter<TransitionsState2View, TransitionsState2Model>(view, model, AppStatesMachine.state2, AppStatesMachine) {

    @Subscribe
    fun onTransition3ButtonClicked(event: Transition3ButtonClickedEvent) {
        onEvent(AppStatesMachine.event3)
    }
}
