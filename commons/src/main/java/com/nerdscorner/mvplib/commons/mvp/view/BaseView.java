package com.nerdscorner.mvplib.commons.mvp.view;

import android.app.Activity;
import android.support.annotation.StringRes;
import android.widget.Toast;

public abstract class BaseView {

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

    public void showToast(String text) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show();
    }

    public void showToast(int duration, @StringRes int textResId) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, activity.getString(textResId), duration).show();
    }

    public void showToast(int duration, String text) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, text, duration).show();
    }

    public void showToast(int duration, @StringRes int textResId, Object... args) {
        Activity activity = getActivity();
        if (activity == null) {
            return;
        }
        Toast.makeText(activity, activity.getString(textResId, args), duration).show();
    }
}