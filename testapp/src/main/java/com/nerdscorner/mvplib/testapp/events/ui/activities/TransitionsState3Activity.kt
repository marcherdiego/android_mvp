package com.nerdscorner.mvplib.testapp.events.ui.activities

import android.os.Bundle

import com.nerdscorner.mvplib.events.activity.BaseActivity
import com.nerdscorner.mvplib.testapp.R

import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.TransitionsState3Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.TransitionsState3Presenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState3View

class TransitionsState3Activity : BaseActivity<TransitionsState3Presenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transitions_state3_activity)

        presenter = TransitionsState3Presenter(
                TransitionsState3View(this),
                TransitionsState3Model()
        )
    }
}
