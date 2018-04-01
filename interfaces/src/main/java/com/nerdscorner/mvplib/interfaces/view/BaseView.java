package com.nerdscorner.mvplib.interfaces.view;

import com.nerdscorner.mvplib.interfaces.presenter.BasePresenter;

public class BaseView<P extends BasePresenter> {

    protected P presenter;

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public void unbind() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroyView() {
    }

    public void onStop() {
    }

    public void onStart() {
    }
}
