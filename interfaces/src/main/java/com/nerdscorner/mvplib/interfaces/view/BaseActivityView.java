package com.nerdscorner.mvplib.interfaces.view;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.interfaces.activity.BaseActivity;
import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;

import java.lang.ref.WeakReference;

public abstract class BaseActivityView<P extends BaseActivityPresenter> extends BaseView<P> {

    private WeakReference<BaseActivity> activityRef;

    public BaseActivityView(@NonNull BaseActivity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    @Override
    public BaseActivity getActivity() {
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
