package com.github.marcherdiego.mvp.testapp.ui.activities

import android.os.Bundle

import com.github.marcherdiego.mvp.events.activity.BaseActivity
import com.github.marcherdiego.mvp.testapp.R
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.MultipleWidgetsOnClickListenerModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.presenter.MultipleWidgetsOnClickListenerPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.MultipleWidgetsOnClickListenerView

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
