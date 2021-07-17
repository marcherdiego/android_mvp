package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter

import com.github.marcherdiego.mvp.transitions.presenter.TransitionsActivityPresenter
import com.nerdscorner.mvplib.testapp.events.statesmachine.AppStatesMachine

import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.TransitionsState1Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState1View
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState1View.Transition1ButtonClickedEvent
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState1View.Transition3ButtonClickedEvent
import org.greenrobot.eventbus.Subscribe

class TransitionsState1Presenter(view: TransitionsState1View, model: TransitionsState1Model) :
    TransitionsActivityPresenter<TransitionsState1View, TransitionsState1Model>(view, model, AppStatesMachine.state1, AppStatesMachine) {

    @Subscribe
    fun onTransitionButtonClicked(event: Transition1ButtonClickedEvent) {
        onEvent(AppStatesMachine.event1)
    }
    
    @Subscribe
    fun onTransition3ButtonClicked(event: Transition3ButtonClickedEvent) {
        onEvent(AppStatesMachine.event2)
    }
}
