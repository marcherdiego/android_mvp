package com.nerdscorner.mvplib.testapp.events.behaviour.presenter

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import com.nerdscorner.mvplib.testapp.events.behaviour.model.BehaviourMainModel
import com.nerdscorner.mvplib.testapp.events.behaviour.model.BehaviourMainModel.BackgroundTaskCompletedEvent
import com.nerdscorner.mvplib.testapp.events.behaviour.view.BehaviourMainView
import com.nerdscorner.mvplib.testapp.events.behaviour.view.BehaviourMainView.ActionClickedEvent

import org.greenrobot.eventbus.Subscribe

class BehaviourMainPresenter(view: BehaviourMainView, model: BehaviourMainModel) :
        BaseActivityPresenter<BehaviourMainView, BehaviourMainModel>(view, model) {

    @Subscribe
    fun onActionClicked(event: ActionClickedEvent) {
        view.setTextValue("Executing background task...")
        model.doSomethingInBackground()
    }

    @Subscribe
    fun onBackgroundTaskCompleted(event: BackgroundTaskCompletedEvent) {
        view.setTextValue("Background task completed")
    }
}
