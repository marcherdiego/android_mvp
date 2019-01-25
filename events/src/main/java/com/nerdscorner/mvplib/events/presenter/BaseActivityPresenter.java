package com.nerdscorner.mvplib.events.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import com.nerdscorner.mvplib.commons.mvp.presenter.BasePresenter;
import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.model.BaseEventsModel;
import com.nerdscorner.mvplib.events.view.BaseActivityView;

public class BaseActivityPresenter<V extends BaseActivityView, M extends BaseEventsModel> extends BasePresenter<V, M> {
    private Bus bus;

    public BaseActivityPresenter(@NonNull V view, @NonNull M model) {
        this(view, model, Bus.getDefaultEventBus());
    }

    public BaseActivityPresenter(@NonNull V view, @NonNull M model, @NonNull Bus bus) {
        super(view, model);
        view.setBus(bus);
        model.setBus(bus);
        this.bus = bus;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Bus getBus() {
        return bus;
    }
}
