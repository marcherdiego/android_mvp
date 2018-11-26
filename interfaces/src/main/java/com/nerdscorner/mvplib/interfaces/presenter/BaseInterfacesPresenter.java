package com.nerdscorner.mvplib.interfaces.presenter;

import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.commons.mvp.presenter.BasePresenter;
import com.nerdscorner.mvplib.interfaces.model.BaseInterfacesModel;
import com.nerdscorner.mvplib.interfaces.view.BaseInterfacesView;

abstract class BaseInterfacesPresenter<V extends BaseInterfacesView, M extends BaseInterfacesModel> extends BasePresenter<V, M> {
    BaseInterfacesPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
        view.setPresenter(this);
        model.setPresenter(this);
    }
}
