package com.nerdscorner.mvplib.interfaces.model;

import android.support.annotation.Keep;

import com.nerdscorner.mvplib.interfaces.presenter.BasePresenter;

@Keep
public class BaseModel<P extends BasePresenter> {

    protected P presenter;

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
