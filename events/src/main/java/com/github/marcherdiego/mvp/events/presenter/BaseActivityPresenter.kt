package com.github.marcherdiego.mvp.events.presenter

import android.content.Intent
import android.os.Bundle
import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.model.BaseEventsModel
import com.github.marcherdiego.mvp.events.view.BaseActivityView

open class BaseActivityPresenter<V : BaseActivityView, M : BaseEventsModel>
@JvmOverloads constructor(view: V, model: M, internal val bus: Bus = Bus.defaultBus) : BasePresenter<V, M>(view, model) {

    init {
        view.setBus(bus)
        model.setBus(bus)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {}

    open fun onDestroy() {}
}
