package com.nerdscorner.mvplib.events.view

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.StringRes
import com.nerdscorner.mvplib.events.bus.Bus
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

abstract class BaseWidgetView constructor(view: View, @JvmField protected var bus: Bus = Bus.defaultBus) {

    private val viewRef: WeakReference<View> = WeakReference(view)

    val view: View?
        get() = viewRef.get()

    val context: Context?
        get() = viewRef.get()?.context

    @JvmName("busSetter")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    fun showToast(@StringRes textResId: Int) {
        val context = context ?: return
        Toast.makeText(context, textResId, Toast.LENGTH_SHORT).show()
    }

    fun showToast(@StringRes textResId: Int, vararg args: Any) {
        val context = context ?: return
        Toast.makeText(context, context.getString(textResId, *args), Toast.LENGTH_SHORT).show()
    }

    fun showToast(text: String?) {
        val context = context ?: return
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    fun showToast(duration: Int, @StringRes textResId: Int) {
        val context = context ?: return
        Toast.makeText(context, context.getString(textResId), duration).show()
    }

    fun showToast(duration: Int, text: String?) {
        val context = context ?: return
        Toast.makeText(context, text, duration).show()
    }

    fun showToast(duration: Int, @StringRes textResId: Int, vararg args: Any) {
        val context = context ?: return
        Toast.makeText(context, context.getString(textResId, *args), duration).show()
    }

    fun onClick(@IdRes id: Int, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        view?.findViewById<View>(id)?.setOnClickListener {
            bus.post(event, threadMode)
            block(it)
        }
    }

    fun onClick(@IdRes vararg ids: Int, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        val onClickListener = View.OnClickListener {
            bus.post(event, threadMode)
            block(it)
        }
        ids.forEach {
            view?.findViewById<View>(it)?.setOnClickListener(onClickListener)
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
}
