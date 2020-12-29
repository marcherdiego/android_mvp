package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.Fragment1Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.Fragment1View

import org.greenrobot.eventbus.NoSubscriberEvent
import org.greenrobot.eventbus.Subscribe

class Fragment1Presenter(view: Fragment1View, model: Fragment1Model, bus: Bus) :
        BaseFragmentPresenter<Fragment1View, Fragment1Model>(view, model, bus) {
    init {
        view.setText("Fragment 1")
    }

    @Subscribe
    fun onNoSubscriber(event: NoSubscriberEvent) {
    }
}
