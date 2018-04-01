package com.nerdscorner.mvplib.events.view;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nerdscorner.mvplib.events.activity.BaseActivity;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

@Keep
public abstract class BaseActivityView extends BaseView {

    protected final EventBus bus;
    private WeakReference<BaseActivity> activityRef;

    public BaseActivityView(@NonNull BaseActivity activity) {
        activityRef = new WeakReference<>(activity);
        bus = EventBus.getDefault();
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
