package com.nerdscorner.mvplib.testapp.events;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.nerdscorner.mvplib.commons.mvp.activity.BaseActivity;
import com.nerdscorner.mvplib.events.behaviour.MvpEventsBehaviour;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.model.MainModel;
import com.nerdscorner.mvplib.testapp.events.presenter.MainPresenter;
import com.nerdscorner.mvplib.testapp.events.view.MainView;

public class EventsMainActivity extends BaseActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getBehaviourCollection().add(
                new MvpEventsBehaviour(
                        new MainPresenter(
                                new MainView(this),
                                new MainModel()
                        )
                )
        );
    }
}
