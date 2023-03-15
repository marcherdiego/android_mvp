package com.github.marcherdiego.mvp.testapp.ui.activities

import android.os.Bundle
import com.github.marcherdiego.mvp.events.activity.BaseActivity
import com.github.marcherdiego.mvp.events.config.annotations.RegisterAt
import com.github.marcherdiego.mvp.events.config.annotations.UnregisterAt
import com.github.marcherdiego.mvp.testapp.R
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.InheritanceMainModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.presenter.InheritanceMainPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.InheritanceMainView

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
