package com.nerdscorner.mvplib.interfaces.presenter;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.nerdscorner.mvplib.interfaces.model.BaseModel;
import com.nerdscorner.mvplib.interfaces.view.BaseView;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    protected V view;
    protected M model;

    public BasePresenter(@NonNull V view, @NonNull M model) {
        this.view = view;
        this.model = model;
        view.setPresenter(this);
        model.setPresenter(this);
    }

    public void onStart() {
        view.onStart();
        model.onStart();
    }

    public void onResume() {
        view.onResume();
        model.onResume();
    }

    public void onPause() {
        view.onPause();
        model.onPause();
    }

    public void onStop() {
        view.onStop();
        model.onStop();
    }

    public void onDestroyView() {
        view.onDestroyView();
        view.unbind();
    }

    public boolean onBackPressed() {
        return false;
    }

    public void onConfigurationChanged(Configuration newConfig) {
    }

    public void onSaveInstanceState(Bundle outState) {
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
