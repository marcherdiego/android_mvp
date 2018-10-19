package com.nerdscorner.mvplib.events.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel;
import com.nerdscorner.mvplib.commons.mvp.presenter.BasePresenter;
import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.view.BaseFragmentView;

public class BaseFragmentPresenter<V extends BaseFragmentView, M extends BaseModel> extends BasePresenter<V, M> {
    private Bus bus = Bus.getDefaultEventBus();

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model, @NonNull Bus bus) {
        super(view, model);
        this.bus = bus;
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
