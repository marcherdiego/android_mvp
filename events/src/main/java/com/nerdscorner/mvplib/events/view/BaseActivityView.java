package com.nerdscorner.mvplib.events.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.commons.mvp.view.BaseView;
import com.nerdscorner.mvplib.events.bus.Bus;

import java.lang.ref.WeakReference;

public abstract class BaseActivityView extends BaseView {

    private WeakReference<AppCompatActivity> activityRef;
    protected Bus bus;

    public BaseActivityView(@NonNull AppCompatActivity activity) {
        this(activity, Bus.getDefaultEventBus());
    }

    public BaseActivityView(@NonNull AppCompatActivity activity, @NonNull Bus bus) {
        activityRef = new WeakReference<>(activity);
        this.bus = bus;
    }

    @Nullable
    @Override
    public AppCompatActivity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        AppCompatActivity activity = getActivity();
        return activity != null ? activity.getSupportFragmentManager() : null;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void onDestroy() {
    }
}
