package com.github.marcherdiego.mvp.events.view

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.marcherdiego.mvp.events.bus.Bus
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

abstract class BaseActivityView @JvmOverloads constructor(activity: AppCompatActivity, bus: Bus = Bus.defaultBus) : BaseView(bus) {

    override val activity: AppCompatActivity?
        get() = activityRef.get()

    private val activityRef: WeakReference<AppCompatActivity> = WeakReference(activity)

    override val fragmentManager: FragmentManager?
        get() = activityRef.get()?.supportFragmentManager

    @JvmName("busSetter")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    fun onClick(@IdRes viewId: Int, block: (View) -> Unit = {}) {
        activity?.findViewById<View>(viewId)?.setOnClickListener {
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

    override fun withFragmentManager(block: FragmentManager.() -> Unit): Unit? {
        return fragmentManager?.run {
            block(this)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Fragment> findFragmentByTag(tag: String?) = fragmentManager?.findFragmentByTag(tag) as? T

    override fun existsFragmentWithTag(tag: String?) = findFragmentByTag<Fragment>(tag) != null

    override fun <T : Fragment> withFragmentByTag(tag: String?, block: T.(fragmentManager: FragmentManager) -> Unit): Unit? {
        return findFragmentByTag<T>(tag)?.run {
            block(this, parentFragmentManager)
        }
    }

    override fun withFragmentTransaction(block: FragmentTransaction.() -> Unit): Unit? {
        return block(fragmentManager?.beginTransaction() ?: return null)
    }
}
