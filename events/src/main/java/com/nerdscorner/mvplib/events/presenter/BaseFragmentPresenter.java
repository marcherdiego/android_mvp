package com.nerdscorner.mvplib.events.presenter;

import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.events.model.BaseModel;
import com.nerdscorner.mvplib.events.view.BaseFragmentView;

public class BaseFragmentPresenter<V extends BaseFragmentView, M extends BaseModel> extends BasePresenter<V, M> {
    public BaseFragmentPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }
}
