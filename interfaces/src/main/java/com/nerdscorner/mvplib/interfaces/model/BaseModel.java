package com.nerdscorner.mvplib.interfaces.model;

import com.nerdscorner.mvplib.interfaces.presenter.BasePresenter;

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
