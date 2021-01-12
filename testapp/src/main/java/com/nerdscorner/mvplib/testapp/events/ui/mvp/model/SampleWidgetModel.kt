package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import com.nerdscorner.mvplib.events.model.BaseWidgetModel

class SampleWidgetModel : BaseWidgetModel() {

    fun doSomething() {
        bus.post(SomeDummyEvent())
    }

    class SomeDummyEvent
}
