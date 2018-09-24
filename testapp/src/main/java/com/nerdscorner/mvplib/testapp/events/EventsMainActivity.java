package com.nerdscorner.mvplib.testapp.events;

import android.os.Bundle;

import com.nerdscorner.mvplib.commons.activity.BaseActivity;
import com.nerdscorner.mvplib.events.behaviour.MvpEventsBehaviour;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.model.MainModel;
import com.nerdscorner.mvplib.testapp.events.presenter.MainPresenter;
import com.nerdscorner.mvplib.testapp.events.view.MainView;

public class EventsMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBehaviour(
                new MvpEventsBehaviour(
                        new MainPresenter(
                                new MainView(this),
                                new MainModel()
                        )
                )
        );
    }
}
