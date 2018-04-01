package com.nerdscorner.mvplib.events.activity;

import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

import org.greenrobot.eventbus.EventBus;

public class BaseActivity extends AppCompatActivity {

    protected BaseActivityPresenter presenter;

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        try {
            EventBus.getDefault().register(presenter);
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
            EventBus.getDefault().unregister(presenter);
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public void onBackPressed() {
        if (!presenter.onBackPressed()) {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return presenter.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return presenter.onOptionsItemSelected(item);
    }
}
