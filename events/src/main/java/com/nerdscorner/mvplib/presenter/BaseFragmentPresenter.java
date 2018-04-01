package com.nerdscorner.mvplib.presenter;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.model.BaseModel;
import com.nerdscorner.mvplib.view.BaseFragmentView;

@Keep
public class BaseFragmentPresenter<V extends BaseFragmentView, M extends BaseModel> {
    protected V view;
    protected M model;

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model) {
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

    public void onDestroyView() {
        view.onDestroyView();
        view.unbind();
    }

    public boolean onBackPressed() {
        return false;
    }
}
