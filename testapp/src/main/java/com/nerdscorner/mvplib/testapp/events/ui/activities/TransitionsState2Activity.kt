package com.nerdscorner.mvplib.testapp.events.ui.activities

import android.os.Bundle

import com.nerdscorner.mvplib.events.activity.BaseActivity
import com.nerdscorner.mvplib.testapp.R

import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.TransitionsState2Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.TransitionsState2Presenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState2View

class TransitionsState2Activity : BaseActivity<TransitionsState2Presenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transitions_state2_activity)

        presenter = TransitionsState2Presenter(
            TransitionsState2View(this),
            TransitionsState2Model()
        )
    }
}
