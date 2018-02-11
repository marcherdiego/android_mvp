package com.nerdscorner.mvplib.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.bus.EventBusWrapper;
import com.nerdscorner.mvplib.presenter.BaseActivityPresenter;

public class BaseActivity extends AppCompatActivity {

    protected BaseActivityPresenter presenter;
    protected EventBusWrapper bus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = EventBusWrapper.getDefault();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            bus.register(presenter);
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
        presenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        presenter.onPause();
        try {
            bus.unregister(presenter);
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
    }

    @Override
    public void onBackPressed() {
        if (!presenter.onBackPressed()) {
            super.onBackPressed();
        }
    }
}
