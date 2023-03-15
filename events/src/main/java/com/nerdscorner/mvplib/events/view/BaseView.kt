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

abstract class BaseView(@JvmField var bus: Bus = Bus.defaultBus) {
    abstract val activity: Activity?
    abstract val fragmentManager: FragmentManager?

    open fun unbind() {}

    fun showToast(@StringRes textResId: Int) {
        withActivity {
            Toast.makeText(this, textResId, Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(@StringRes textResId: Int, vararg args: Any) {
        withActivity {
            Toast.makeText(this, getString(textResId, *args), Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(text: String?) {
        withActivity {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(duration: Int, @StringRes textResId: Int) {
        withActivity {
            Toast.makeText(this, getString(textResId), duration).show()
        }
    }

    fun showToast(duration: Int, text: String?) {
        withActivity {
            Toast.makeText(this, text, duration).show()
        }
    }

    fun showToast(duration: Int, @StringRes textResId: Int, vararg args: Any) {
        withActivity {
            Toast.makeText(this, getString(textResId, *args), duration).show()
        }
    }

    inline fun withActivity(block: Activity.() -> Unit) {
        activity?.run {
            if (isFinishing.not()) {
                block(this)
            }
        }
    }

    fun onClick(view: View?, block: (View) -> Unit = {}) {
        view?.setOnClickListener {
            block(it)
        }
    }

    fun onClick(view: View?, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        onClick(view) {
            bus.post(event, threadMode)
            block(it)
        }
    }

    fun onClick(vararg view: View, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        view.forEach {
            onClick(it) { v ->
                bus.post(event, threadMode)
                block(v)
            }
        }
    }

    fun <T : View> onClickView(vararg view: T, block: (T) -> Unit) {
        view.forEach {
            onClick(it) { v ->
                block(v as T)
            }
        }
    }

    abstract fun withFragmentManager(block: FragmentManager.() -> Unit): Unit?

    abstract fun <T : Fragment> findFragmentByTag(tag: String?): Fragment?

    abstract fun existsFragmentWithTag(tag: String?): Boolean

    abstract fun <T : Fragment> withFragmentByTag(tag: String?, block: T.(fragmentManager: FragmentManager) -> Unit): Unit?

    abstract fun withFragmentTransaction(block: FragmentTransaction.() -> Unit): Unit?

    fun runOnUiThread(block: Activity.() -> Unit) {
        withActivity {
            runOnUiThread {
                block(this)
            }
        }
    }

    fun post(event: Any, threadMode: ThreadMode = ThreadMode.POSTING) {
        bus.post(event, threadMode)
    }

    fun postSticky(event: Any) {
        bus.postSticky(event)
    }

    fun postDefault(event: Any, threadMode: ThreadMode = ThreadMode.POSTING) {
        Bus.postDefault(event, threadMode)
    }

    fun postStickyDefault(event: Any) {
        Bus.postStickyDefault(event)
    }
}
