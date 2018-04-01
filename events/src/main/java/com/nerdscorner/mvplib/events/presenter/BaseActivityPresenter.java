package com.nerdscorner.mvplib.events.presenter;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.events.model.BaseModel;
import com.nerdscorner.mvplib.events.view.BaseActivityView;

@Keep
public class BaseActivityPresenter<V extends BaseActivityView, M extends BaseModel> {
    protected V view;
    protected M model;

    public BaseActivityPresenter(@NonNull V view, @NonNull M model) {
        this.view = view;
        this.model = model;
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

    public boolean onBackPressed() {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
