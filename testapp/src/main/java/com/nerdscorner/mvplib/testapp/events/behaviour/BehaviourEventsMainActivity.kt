package com.nerdscorner.mvplib.testapp.events.behaviour

import android.os.Bundle

import com.nerdscorner.mvplib.commons.behaviour.BaseActivity
import com.nerdscorner.mvplib.events.behaviour.MvpEventsBehaviour
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.behaviour.model.BehaviourMainModel
import com.nerdscorner.mvplib.testapp.events.behaviour.presenter.BehaviourMainPresenter
import com.nerdscorner.mvplib.testapp.events.behaviour.view.BehaviourMainView

class BehaviourEventsMainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)
        addBehaviour(
                MvpEventsBehaviour(
                        BehaviourMainPresenter(
                                BehaviourMainView(this),
                                BehaviourMainModel()
                        )
                )
        )
    }
}
