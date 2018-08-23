package com.nerdscorner.mvplib.testapp.interfaces;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.nerdscorner.mvplib.commons.behaviour.BehaviourCollection;
import com.nerdscorner.mvplib.commons.mvp.activity.BaseActivity;
import com.nerdscorner.mvplib.interfaces.behaviour.MvpInterfacesBehaviour;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.model.MainModel;
import com.nerdscorner.mvplib.testapp.interfaces.presenter.MainPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.view.MainView;

public class InterfacesMainActivity extends BaseActivity {

    @SuppressLint("CheckResult")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BehaviourCollection behaviourCollection = getBehaviourCollection();
        if (behaviourCollection != null) {
            behaviourCollection.add(
                    new MvpInterfacesBehaviour(
                            new MainPresenter(
                                    new MainView(this),
                                    new MainModel()
                            )
                    )
            );
        }
    }
}
