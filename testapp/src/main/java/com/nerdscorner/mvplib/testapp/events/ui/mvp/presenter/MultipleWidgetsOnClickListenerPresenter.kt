package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter

import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.MultipleWidgetsOnClickListenerModel
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.MultipleWidgetsOnClickListenerView
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.MultipleWidgetsOnClickListenerView.ButtonClickedEvent
import org.greenrobot.eventbus.Subscribe

class MultipleWidgetsOnClickListenerPresenter(view: MultipleWidgetsOnClickListenerView, model: MultipleWidgetsOnClickListenerModel) :
    BaseActivityPresenter<MultipleWidgetsOnClickListenerView, MultipleWidgetsOnClickListenerModel>(view, model) {
    
    @Subscribe
    fun onButtonClicked(event: ButtonClickedEvent) {
        view.showToast("Clicked button ${event.text}")
    }
}
