package com.github.marcherdiego.mvp.testapp.ui.mvp.presenter

import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.presenter.BaseFragmentPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.Fragment2Model
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.Fragment2View

import org.greenrobot.eventbus.NoSubscriberEvent
import org.greenrobot.eventbus.Subscribe

class Fragment2Presenter(view: Fragment2View, model: Fragment2Model, bus: Bus) :
    BaseFragmentPresenter<Fragment2View, Fragment2Model>(view, model, bus) {
    init {
        view.setText("Fragment 2")
    }

    @Subscribe
    fun onNoSubscribers(event: NoSubscriberEvent) {
    }
}
