package com.nerdscorner.mvplib.interfaces.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;

import java.lang.ref.WeakReference;

public abstract class BaseActivityView<P extends Presenter> extends BaseInterfacesView<P> {

    private WeakReference<AppCompatActivity> activityRef;

    public BaseActivityView(@NonNull AppCompatActivity activity) {
        activityRef = new WeakReference<>(activity);
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

    public void onDestroy() {
    }
}
