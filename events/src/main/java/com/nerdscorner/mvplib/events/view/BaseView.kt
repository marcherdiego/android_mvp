package com.nerdscorner.mvplib.events.view

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.FragmentManager

abstract class BaseView {
    abstract val activity: Activity?
    abstract val fragmentManager: FragmentManager?

    open fun unbind() {}

    open fun onResume() {}

    open fun onPause() {}

    open fun onDestroyView() {}

    open fun onStop() {}

    open fun onStart() {}

    fun showToast(@StringRes textResId: Int) {
        val activity = activity ?: return
        Toast.makeText(activity, textResId, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes textResId: Int, vararg args: Any) {
        val activity = activity ?: return
        Toast.makeText(activity, activity.getString(textResId, *args), Toast.LENGTH_SHORT).show()
    }

    fun showToast(text: String?) {
        val activity = activity ?: return
        Toast.makeText(activity, text, Toast.LENGTH_SHORT).show()
    }

    fun showToast(duration: Int, @StringRes textResId: Int) {
        val activity = activity ?: return
        Toast.makeText(activity, activity.getString(textResId), duration).show()
    }

    fun showToast(duration: Int, text: String?) {
        val activity = activity ?: return
        Toast.makeText(activity, text, duration).show()
    }

    fun showToast(duration: Int, @StringRes textResId: Int, vararg args: Any) {
        val activity = activity ?: return
        Toast.makeText(activity, activity.getString(textResId, *args), duration).show()
    }

    fun withActivity(block: Activity.() -> Unit) {
        activity?.run {
            if (!isFinishing) {
                block(this)
            }
        }
    }

    fun withFragmentManager(block: FragmentManager.() -> Unit) {
        fragmentManager?.run {
            block(this)
        }
    }
}
