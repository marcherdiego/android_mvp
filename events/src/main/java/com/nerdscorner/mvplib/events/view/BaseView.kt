package com.nerdscorner.mvplib.events.view

import android.app.Activity
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

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

    inline fun withActivity(block: Activity.() -> Unit) {
        activity?.run {
            if (!isFinishing) {
                block(this)
            }
        }
    }

    abstract fun withFragmentManager(block: FragmentManager.() -> Unit)

    abstract fun <T : Fragment> findFragmentByTag(tag: String): Fragment?

    abstract fun existsFragmentWithTag(tag: String): Boolean

    abstract fun <T : Fragment> withFragmentByTag(tag: String, block: (fragment: T, fragmentManager: FragmentManager) -> Unit)

    abstract fun withFragmentTransaction(block: FragmentTransaction.() -> Unit)
}
