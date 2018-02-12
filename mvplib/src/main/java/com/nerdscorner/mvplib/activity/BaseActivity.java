package com.nerdscorner.mvplib.activity;

import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.bus.EventBusWrapper;
import com.nerdscorner.mvplib.presenter.BaseActivityPresenter;

public class BaseActivity extends AppCompatActivity {

    protected BaseActivityPresenter presenter;

    @Override
    protected void onResume() {
        super.onResume();
        try {
            EventBusWrapper.getDefault().register(presenter);
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
            EventBusWrapper.getDefault().unregister(presenter);
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
