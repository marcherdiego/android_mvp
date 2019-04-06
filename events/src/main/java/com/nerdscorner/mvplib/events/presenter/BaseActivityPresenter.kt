package com.nerdscorner.mvplib.events.presenter

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.events.view.BaseActivityView

open class BaseActivityPresenter<V : BaseActivityView, M : BaseEventsModel>
@JvmOverloads constructor(view: V, model: M, internal val bus: Bus = Bus.defaultBus) :
        BasePresenter<V, M>(view, model) {

    init {
        view.setBus(bus)
        model.setBus(bus)
    }

    open fun onCreateOptionsMenu(menu: Menu): Boolean {
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>,
                                            grantResults: IntArray) {
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {}
}
