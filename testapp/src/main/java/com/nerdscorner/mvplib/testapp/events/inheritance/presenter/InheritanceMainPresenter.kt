package com.nerdscorner.mvplib.testapp.events.inheritance.presenter

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import com.nerdscorner.mvplib.testapp.events.inheritance.model.InheritanceMainModel
import com.nerdscorner.mvplib.testapp.events.inheritance.model.InheritanceMainModel.BackgroundTaskCompletedEvent
import com.nerdscorner.mvplib.testapp.events.inheritance.view.InheritanceMainView
import com.nerdscorner.mvplib.testapp.events.inheritance.view.InheritanceMainView.ActionClickedEvent
import org.greenrobot.eventbus.Subscribe

class InheritanceMainPresenter(view: InheritanceMainView, model: InheritanceMainModel) :
        BaseActivityPresenter<InheritanceMainView, InheritanceMainModel>(view, model) {

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
