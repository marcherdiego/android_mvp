package com.nerdscorner.mvplib.interfaces.view;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nerdscorner.mvplib.interfaces.activity.BaseActivity;
import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;

import java.lang.ref.WeakReference;

@Keep
public abstract class BaseActivityView<P extends BaseActivityPresenter> extends BaseView<P> {

    private WeakReference<BaseActivity> activityRef;

    public BaseActivityView(@NonNull BaseActivity activity) {
        activityRef = new WeakReference<>(activity);
    }

    @Nullable
    public BaseActivity getActivity() {
        return activityRef.get();
    }

    @Nullable
    public FragmentManager getFragmentManager() {
        AppCompatActivity activity = getActivity();
        return activity != null ? activity.getSupportFragmentManager() : null;
    }

    public void showToast(@StringRes int textResId) {
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, textResId, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int textResId, Object... args) {
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, activity.getString(textResId, args), Toast.LENGTH_SHORT).show();
    }
}
