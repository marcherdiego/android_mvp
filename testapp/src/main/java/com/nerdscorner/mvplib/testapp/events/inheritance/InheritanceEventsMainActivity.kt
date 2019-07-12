package com.nerdscorner.mvplib.testapp.events.inheritance

import android.os.Bundle
import com.nerdscorner.mvplib.events.activity.BaseActivity
import com.nerdscorner.mvplib.events.config.annotations.RegisterAt
import com.nerdscorner.mvplib.events.config.annotations.RegistrationMode
import com.nerdscorner.mvplib.events.config.annotations.UnregisterAt
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.inheritance.model.InheritanceMainModel
import com.nerdscorner.mvplib.testapp.events.inheritance.presenter.InheritanceMainPresenter
import com.nerdscorner.mvplib.testapp.events.inheritance.view.InheritanceMainView

@RegistrationMode(registerAt = RegisterAt.ON_START, unregisterAt = UnregisterAt.ON_STOP)
class InheritanceEventsMainActivity : BaseActivity<InheritanceMainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        presenter = InheritanceMainPresenter(
                InheritanceMainView(this),
                InheritanceMainModel()
        )
    }
}
