package com.nerdscorner.mvplib.events.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.nerdscorner.mvplib.commons.mvp.view.BaseView;
import com.nerdscorner.mvplib.events.bus.Bus;

import java.lang.ref.WeakReference;

public abstract class BaseFragmentView extends BaseView {

    private WeakReference<Fragment> fragmentRef;
    protected Bus bus;

    public BaseFragmentView(@NonNull Fragment fragment) {
        fragmentRef = new WeakReference<>(fragment);
        bus = Bus.Companion.getDefaultEventBus();
    }

    public BaseFragmentView(@NonNull Fragment fragment, @NonNull Bus bus) {
        fragmentRef = new WeakReference<>(fragment);
        this.bus = bus;
    }

    @Nullable
    @Override
    public FragmentActivity getActivity() {
        Fragment fragment = fragmentRef.get();
        return (fragment == null) ? null : fragment.getActivity();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        FragmentActivity activity = getActivity();
        return activity != null ? activity.getSupportFragmentManager() : null;
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

    @Nullable
    public Fragment getFragment() {
        return fragmentRef.get();
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}
