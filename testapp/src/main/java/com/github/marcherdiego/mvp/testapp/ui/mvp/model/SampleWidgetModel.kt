package com.github.marcherdiego.mvp.testapp.ui.mvp.model

import com.github.marcherdiego.mvp.events.model.BaseWidgetModel

class SampleWidgetModel : BaseWidgetModel() {

    fun doSomething() {
        bus.post(SomeDummyEvent())
    }

    class SomeDummyEvent
}
