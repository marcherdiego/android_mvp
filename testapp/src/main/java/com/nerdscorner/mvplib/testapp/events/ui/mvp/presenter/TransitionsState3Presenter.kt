package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter

import com.github.marcherdiego.mvp.transitions.TransitionsActivityPresenter
import com.nerdscorner.mvplib.testapp.events.statesmachine.AppStatesMachine

import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.TransitionsState3Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState3View

class TransitionsState3Presenter(view: TransitionsState3View, model: TransitionsState3Model) :
    TransitionsActivityPresenter<TransitionsState3View, TransitionsState3Model>(view, model, AppStatesMachine.state3, AppStatesMachine) {

    override fun onBackPressed(): Boolean {
        onEvent(AppStatesMachine.event4)
        return true
    }
}
