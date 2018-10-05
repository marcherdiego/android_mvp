package com.nerdscorner.mvplib.testapp.interfaces.behaviour;

import android.os.Bundle;

import com.nerdscorner.mvplib.commons.behaviour.BaseActivity;
import com.nerdscorner.mvplib.interfaces.behaviour.MvpInterfacesBehaviour;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.model.MainModel;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter.MainPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.view.MainView;

public class BehaviourInterfacesMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addBehaviour(
                new MvpInterfacesBehaviour(
                        new MainPresenter(
                                new MainView(this),
                                new MainModel()
                        )
                )
        );
    }
}
