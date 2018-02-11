package com.nerdscorner.mvplib.presenter;

import android.support.annotation.Keep;

import com.nerdscorner.mvplib.model.BaseModel;
import com.nerdscorner.mvplib.view.BaseActivityView;

@Keep
public class BaseActivityPresenter<V extends BaseActivityView, M extends BaseModel> {
    protected V view;
    protected M model;

    public BaseActivityPresenter(V view, M model) {
        this.view = view;
        this.model = model;
    }

    public void onResume() {
        view.onResume();
        model.onResume();
    }

    public void onPause() {
        view.onPause();
        model.onPause();
    }

    public boolean onBackPressed() {
        return false;
    }
}
