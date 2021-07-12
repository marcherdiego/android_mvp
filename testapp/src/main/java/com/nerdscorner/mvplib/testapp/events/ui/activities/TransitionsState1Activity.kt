package com.nerdscorner.mvplib.testapp.events.ui.activities

import android.os.Bundle

import com.nerdscorner.mvplib.events.activity.BaseActivity

import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.TransitionsState1Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.TransitionsState1Presenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.TransitionsState1View

class TransitionsState1Activity : BaseActivity<TransitionsState1Presenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.transitions_activity)

        presenter = TransitionsState1Presenter(
            TransitionsState1View(this),
            TransitionsState1Model()
        )
    }
}
