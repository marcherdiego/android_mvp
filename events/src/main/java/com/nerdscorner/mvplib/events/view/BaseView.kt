package com.nerdscorner.mvplib.events.view

import android.app.Activity
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nerdscorner.mvplib.events.bus.Bus
import org.greenrobot.eventbus.ThreadMode

abstract class BaseView(@JvmField protected var bus: Bus = Bus.defaultBus) {
    abstract val activity: Activity?
    abstract val fragmentManager: FragmentManager?

    open fun unbind() {}

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

    fun onClick(view: View, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        view.setOnClickListener {
            bus.post(event, threadMode)
            block(it)
        }
    }

    fun onClick(vararg view: View, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        val onClickListener = View.OnClickListener {
            bus.post(event, threadMode)
            block(it)
        }
        view.forEach {
            it.setOnClickListener(onClickListener)
        }
    }

    abstract fun withFragmentManager(block: FragmentManager.() -> Unit): Unit?

    abstract fun <T : Fragment> findFragmentByTag(tag: String?): Fragment?

    abstract fun existsFragmentWithTag(tag: String?): Boolean

    abstract fun <T : Fragment> withFragmentByTag(tag: String?, block: T.(fragmentManager: FragmentManager) -> Unit): Unit?

    abstract fun withFragmentTransaction(block: FragmentTransaction.() -> Unit): Unit?
}
