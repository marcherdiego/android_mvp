package com.nerdscorner.mvplib.commons.mvp.view

import android.app.Activity
import android.support.annotation.StringRes
import android.widget.Toast

abstract class BaseView {
    abstract val activity: Activity?

    fun unbind() {}

    fun onResume() {}

    fun onPause() {}

    fun onDestroyView() {}

    fun onStop() {}

    fun onStart() {}

    fun showToast(@StringRes textResId: Int) {
        val activity = activity ?: return
        Toast.makeText(activity, textResId, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes textResId: Int, vararg args: Any) {
        val activity = activity ?: return
        Toast.makeText(activity, activity.getString(textResId, *args), Toast.LENGTH_SHORT).show()
    }

    fun showToast(text: String) {
        val activity = activity ?: return
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    fun showToast(duration: Int, @StringRes textResId: Int) {
        val activity = activity ?: return
        Toast.makeText(activity, activity.getString(textResId), duration).show()
    }

    fun showToast(duration: Int, text: String) {
        val activity = activity ?: return
        Toast.makeText(activity, text, duration).show()
    }

    fun showToast(duration: Int, @StringRes textResId: Int, vararg args: Any) {
        val activity = activity ?: return
        Toast.makeText(activity, activity.getString(textResId, *args), duration).show()
    }
}
