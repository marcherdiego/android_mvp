package com.nerdscorner.mvplib.events.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import com.nerdscorner.mvplib.commons.mvp.presenter.BasePresenter;
import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.model.BaseEventsModel;
import com.nerdscorner.mvplib.events.view.BaseFragmentView;

public class BaseFragmentPresenter<V extends BaseFragmentView, M extends BaseEventsModel> extends BasePresenter<V, M> {
    private Bus bus;

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model) {
        this(view, model, Bus.Companion.getDefaultEventBus());
    }

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model, @NonNull Bus bus) {
        super(view, model);
        view.setBus(bus);
        model.setBus(bus);
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
