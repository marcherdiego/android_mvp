package com.nerdscorner.mvplib.testapp.interfaces;

import android.os.Bundle;

import com.nerdscorner.mvplib.commons.activity.BaseActivity;
import com.nerdscorner.mvplib.interfaces.behaviour.MvpInterfacesBehaviour;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.model.MainModel;
import com.nerdscorner.mvplib.testapp.interfaces.presenter.MainPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.view.MainView;

public class InterfacesMainActivity extends BaseActivity {

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
