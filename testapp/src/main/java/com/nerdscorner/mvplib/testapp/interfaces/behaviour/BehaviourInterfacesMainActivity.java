package com.nerdscorner.mvplib.testapp.interfaces.behaviour;

import android.os.Bundle;

import com.nerdscorner.mvplib.commons.behaviour.BaseActivity;
import com.nerdscorner.mvplib.interfaces.behaviour.MvpInterfacesBehaviour;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.model.BehaviourMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter.BehaviourMainPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.view.BehaviourMainView;

public class BehaviourInterfacesMainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addBehaviour(
                new MvpInterfacesBehaviour(
                        new BehaviourMainPresenter(
                                new BehaviourMainView(this),
                                new BehaviourMainModel()
                        )
                )
        );
    }
}
