package com.nerdscorner.mvplib.events.view

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.nerdscorner.mvplib.events.bus.Bus
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

abstract class BaseWidgetView constructor(view: View, @JvmField var bus: Bus = Bus.defaultBus) {

    private val viewRef: WeakReference<View> = WeakReference(view)

    val view: View?
        get() = viewRef.get()

    val context: Context?
        get() = viewRef.get()?.context

    @JvmName("setBusValue")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    fun showToast(@StringRes textResId: Int) {
        withContext {
            Toast.makeText(this, textResId, Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(@StringRes textResId: Int, vararg args: Any) {
        withContext {
            Toast.makeText(this, getString(textResId, *args), Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(text: String?) {
        withContext {
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
        }
    }

    fun showToast(duration: Int, @StringRes textResId: Int) {
        withContext {
            Toast.makeText(this, getString(textResId), duration).show()
        }
    }

    fun showToast(duration: Int, text: String?) {
        withContext {
            Toast.makeText(this, text, duration).show()
        }
    }

    fun showToast(duration: Int, @StringRes textResId: Int, vararg args: Any) {
        withContext {
            Toast.makeText(this, getString(textResId, *args), duration).show()
        }
    }

    inline fun withContext(block: Context.() -> Unit) {
        context?.run {
            block(this)
        }
    }

    fun onClick(@IdRes viewId: Int, block: (View) -> Unit = {}) {
        view?.findViewById<View>(viewId)?.setOnClickListener {
            block(it)
        }
    }

    fun onClick(@IdRes viewId: Int, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        onClick(viewId) {
            bus.post(event, threadMode)
            block(it)
        }
    }

    fun onClick(@IdRes vararg ids: Int, block: (View) -> Unit = {}) {
        ids.forEach {
            onClick(it) { v ->
                block(v)
            }
        }
    }

    fun <T: View> onClickView(@IdRes vararg ids: Int, block: (T) -> Unit) {
        ids.forEach {
            onClick(it) { v ->
                block(v as T)
            }
        }
    }

    fun onClick(@IdRes vararg ids: Int, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        ids.forEach {
            onClick(it) { v ->
                bus.post(event, threadMode)
                block(v)
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

    fun post(event: Any) {
        bus.post(event)
    }
}
