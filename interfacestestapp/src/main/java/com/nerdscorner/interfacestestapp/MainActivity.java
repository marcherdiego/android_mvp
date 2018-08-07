package com.nerdscorner.interfacestestapp;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.nerdscorner.interfacestestapp.mvp.model.implementations.MainModel;
import com.nerdscorner.interfacestestapp.mvp.presenter.implementations.MainPresenter;
import com.nerdscorner.interfacestestapp.mvp.view.implementations.MainView;
import com.nerdscorner.mvplib.interfaces.activity.BaseActivity;
import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }

    @NonNull
    @Override
    protected BaseActivityPresenter getPresenter() {
        return new MainPresenter(
                new MainView(this),
                new MainModel()
        );
    }
}
