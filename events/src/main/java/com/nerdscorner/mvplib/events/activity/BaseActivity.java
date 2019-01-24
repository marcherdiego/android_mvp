package com.nerdscorner.mvplib.events.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.events.config.MvpConfig;
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt;
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt;
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

public class BaseActivity<P extends BaseActivityPresenter> extends AppCompatActivity {

    protected P presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (MvpConfig.getRegisterAt() == RegisterAt.ON_CREATE) {
            presenter.getBus().register(presenter);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        if (MvpConfig.getRegisterAt() == RegisterAt.ON_START) {
            presenter.getBus().register(presenter);
        }
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MvpConfig.getRegisterAt() == RegisterAt.ON_RESUME) {
            presenter.getBus().register(presenter);
        }
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        if (MvpConfig.getUnregisterAt() == UnregisterAt.ON_PAUSE) {
            presenter.getBus().unregister(presenter);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
        if (MvpConfig.getUnregisterAt() == UnregisterAt.ON_STOP) {
            presenter.getBus().unregister(presenter);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (MvpConfig.getUnregisterAt() == UnregisterAt.ON_DESTROY) {
            presenter.getBus().unregister(presenter);
        }
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return !presenter.onOptionsItemSelected(item) && super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        presenter.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.onRestoreInstanceState(savedInstanceState);
    }
}
