package com.nerdscorner.mvplib.interfaces.presenter;

import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.interfaces.model.BaseModel;
import com.nerdscorner.mvplib.interfaces.view.BaseFragmentView;

public class BaseFragmentPresenter<V extends BaseFragmentView, M extends BaseModel> extends BasePresenter<V, M> {

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }
}
