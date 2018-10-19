package com.nerdscorner.mvplib.events.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

public class BaseActivity<P extends BaseActivityPresenter> extends AppCompatActivity {

    protected P presenter;

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            if (!presenter.getBus().isRegistered(presenter)) {
                presenter.getBus().register(presenter);
            }
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        try {
            if (presenter.getBus().isRegistered(presenter)) {
                presenter.getBus().unregister(presenter);
            }
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
    }

    @Override
    public void onStop() {
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
