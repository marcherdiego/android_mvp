package com.nerdscorner.mvplib.presenter;

import android.support.annotation.Keep;

import com.nerdscorner.mvplib.model.BaseModel;
import com.nerdscorner.mvplib.view.BaseFragmentView;

@Keep
public class BaseFragmentPresenter<V extends BaseFragmentView, M extends BaseModel> {
    protected V view;
    protected M model;

    public BaseFragmentPresenter(V view, M model) {
        this.view = view;
        this.model = model;
    }

    public void unbind() {
        view.unbind();
    }

    public void onResume() {
        view.onResume();
        model.onResume();
    }

    public void onPause() {
        view.onPause();
        model.onPause();
    }

    public void onDestroyView() {
        view.onDestroyView();
    }

    public boolean onBackPressed() {
        return false;
    }
}
