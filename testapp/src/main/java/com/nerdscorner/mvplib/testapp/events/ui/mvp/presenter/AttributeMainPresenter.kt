package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.AttributeMainModel
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.AttributeMainModel.BackgroundTaskCompletedEvent
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.AttributeMainView
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.AttributeMainView.ActionClickedEvent
import org.greenrobot.eventbus.Subscribe

class AttributeMainPresenter(view: AttributeMainView, model: AttributeMainModel, bus: Bus) :
        BaseActivityPresenter<AttributeMainView, AttributeMainModel>(view, model, bus) {

    @Subscribe
    fun onActionClicked(event: ActionClickedEvent) {
        view.setTextValue("Executing background task...")
        model.doSomethingInBackground()
    }

    @Subscribe
    fun onBackgroundTaskCompleted(event: BackgroundTaskCompletedEvent) {
        view.setTextValue("Background task completed ${event.data}")
    }

    override fun onResume() {
        super.onResume()
        view.withActivity {
        }
    }
}
