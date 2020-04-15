package com.nerdscorner.mvplib.testapp.events.widgets

import com.nerdscorner.mvplib.events.presenter.BaseWidgetPresenter
import com.nerdscorner.mvplib.testapp.events.widgets.SampleWidgetModel.SomeDummyEvent
import org.greenrobot.eventbus.Subscribe

class SampleWidgetPresenter(view: SampleWidgetView, model: SampleWidgetModel) :
        BaseWidgetPresenter<SampleWidgetView, SampleWidgetModel>(view, model) {

    @Subscribe
    fun onSomeDummy(event: SomeDummyEvent) {
        view.showToast("onAttached: SomeDummyEvent")
    }

    override fun onAttached() {
        super.onAttached()
        model.doSomething()
    }

    override fun onDetached() {
        super.onDetached()
        view.showToast("onDetached: SEE YA!")
    }
}
