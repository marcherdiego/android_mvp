package com.nerdscorner.mvplib.interfaces.view;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.widget.Toast;

import com.nerdscorner.mvplib.interfaces.presenter.BasePresenter;

public abstract class BaseView<P extends BasePresenter> {

    protected P presenter;

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public void unbind() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroyView() {
    }

    public void onStop() {
    }

    public void onStart() {
    }

    public abstract Activity getActivity();

    public void showToast(@StringRes int textResId) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, textResId, Toast.LENGTH_SHORT).show();
    }

    public void showToast(@StringRes int textResId, Object... args) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, activity.getString(textResId, args), Toast.LENGTH_SHORT).show();
    }

    public void showToast(int duration, @StringRes int textResId) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, activity.getString(textResId), duration).show();
    }

    public void showToast(int duration, @StringRes int textResId, Object... args) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, activity.getString(textResId, args), duration).show();
    }
}
