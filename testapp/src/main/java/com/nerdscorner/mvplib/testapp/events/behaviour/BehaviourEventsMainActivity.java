package com.nerdscorner.mvplib.testapp.events.behaviour;

import android.os.Bundle;

import com.nerdscorner.mvplib.commons.behaviour.BaseActivity;
import com.nerdscorner.mvplib.events.behaviour.MvpEventsBehaviour;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.behaviour.model.BehaviourMainModel;
import com.nerdscorner.mvplib.testapp.events.behaviour.presenter.BehaviourMainPresenter;
import com.nerdscorner.mvplib.testapp.events.behaviour.view.BehaviourMainView;

public class BehaviourEventsMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBehaviour(
                new MvpEventsBehaviour(
                        new BehaviourMainPresenter(
                                new BehaviourMainView(this),
                                new BehaviourMainModel()
                        )
                )
        );
    }
}
