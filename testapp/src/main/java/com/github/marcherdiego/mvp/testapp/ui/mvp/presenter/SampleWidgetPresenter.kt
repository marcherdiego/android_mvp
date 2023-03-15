package com.github.marcherdiego.mvp.testapp.ui.mvp.presenter

import com.github.marcherdiego.mvp.events.presenter.BaseWidgetPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.SampleWidgetModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.SampleWidgetModel.SomeDummyEvent
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.SampleWidgetView
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
