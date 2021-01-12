package com.nerdscorner.mvplib.testapp.events.ui.activities

import android.os.Bundle
import com.nerdscorner.mvplib.events.activity.BaseActivity
import com.nerdscorner.mvplib.events.config.annotations.RegisterAt
import com.nerdscorner.mvplib.events.config.annotations.UnregisterAt
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.InheritanceMainModel
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.InheritanceMainPresenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.InheritanceMainView

class InheritanceEventsMainActivity : BaseActivity<InheritanceMainPresenter>(
        registerAt = RegisterAt.ON_START,
        unregisterAt = UnregisterAt.ON_STOP
) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        presenter = InheritanceMainPresenter(
                InheritanceMainView(this),
                InheritanceMainModel()
        )
    }
}
