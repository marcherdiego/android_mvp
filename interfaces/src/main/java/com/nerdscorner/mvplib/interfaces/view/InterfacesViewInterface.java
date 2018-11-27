package com.nerdscorner.mvplib.interfaces.view;

import android.app.Activity;
import android.support.annotation.StringRes;

public interface InterfacesViewInterface {

    void unbind();

    void onResume();

    void onPause();

    void onDestroyView();

    void onStop();

    void onStart();

    void onDestroy();

    Activity getActivity();

    void showToast(@StringRes int textResId);

    void showToast(@StringRes int textResId, Object... args);

    void showToast(String text);

    void showToast(int duration, @StringRes int textResId);

    void showToast(int duration, String text);

    void showToast(int duration, @StringRes int textResId, Object... args);
}
