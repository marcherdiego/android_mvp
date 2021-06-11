package com.nerdscorner.mvplib.testapp.events.ui.activities

import android.os.Bundle

import com.nerdscorner.mvplib.events.activity.BaseActivity

import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.MultipleWidgetsOnClickListenerModel
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.MultipleWidgetsOnClickListenerPresenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.MultipleWidgetsOnClickListenerView

class MultipleWidgetsOnClickListenerActivity : BaseActivity<MultipleWidgetsOnClickListenerPresenter>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.multiple_widgets_on_click_listener_activity)

        presenter = MultipleWidgetsOnClickListenerPresenter(
            MultipleWidgetsOnClickListenerView(this),
            MultipleWidgetsOnClickListenerModel()
        )
    }
}
