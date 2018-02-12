package com.nerdscorner.mvplib.view;

import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.nerdscorner.mvplib.activity.BaseActivity;
import com.nerdscorner.mvplib.bus.EventBusWrapper;

import java.lang.ref.WeakReference;

@Keep
public abstract class BaseActivityView {

    protected final EventBusWrapper bus;
    private WeakReference<BaseActivity> activityRef;

    public BaseActivityView(BaseActivity activity) {
        activityRef = new WeakReference<>(activity);
        bus = EventBusWrapper.getDefault();
    }

    @Nullable
    public BaseActivity getActivity() {
        return activityRef.get();
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

    public void onResume() {
    }

    public void onPause() {
    }
}
