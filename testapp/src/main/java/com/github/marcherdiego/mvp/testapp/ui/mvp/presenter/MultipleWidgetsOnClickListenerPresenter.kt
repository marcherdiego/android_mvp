package com.github.marcherdiego.mvp.testapp.ui.mvp.presenter

import com.github.marcherdiego.mvp.events.presenter.BaseActivityPresenter

import com.github.marcherdiego.mvp.testapp.ui.mvp.model.MultipleWidgetsOnClickListenerModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.MultipleWidgetsOnClickListenerView
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.MultipleWidgetsOnClickListenerView.ButtonClickedEvent
import org.greenrobot.eventbus.Subscribe

class MultipleWidgetsOnClickListenerPresenter(view: MultipleWidgetsOnClickListenerView, model: MultipleWidgetsOnClickListenerModel) :
    BaseActivityPresenter<MultipleWidgetsOnClickListenerView, MultipleWidgetsOnClickListenerModel>(view, model) {

    @Subscribe
    fun onButtonClicked(event: ButtonClickedEvent) {
        view.showToast("Clicked button ${event.text}")
    }
}
