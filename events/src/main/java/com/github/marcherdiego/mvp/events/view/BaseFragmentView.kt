package com.github.marcherdiego.mvp.events.view

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.github.marcherdiego.mvp.events.bus.Bus
import org.greenrobot.eventbus.ThreadMode
import java.lang.ref.WeakReference

abstract class BaseFragmentView @JvmOverloads constructor(fragment: Fragment, bus: Bus = Bus.defaultBus) : BaseView(bus) {

    private var fragmentRef: WeakReference<Fragment> = WeakReference(fragment)

    override val activity: Activity?
        get() = fragmentRef.get()?.activity

    override val fragmentManager: FragmentManager?
        get() = fragmentRef.get()?.activity?.supportFragmentManager

    val childFragmentManager: FragmentManager?
        get() = fragmentRef.get()?.childFragmentManager

    val context: Context?
        get() = fragmentRef.get()?.context

    val fragment: Fragment?
        get() = fragmentRef.get()

    fun getActivity(): FragmentActivity? {
        return fragmentRef.get()?.activity
    }

    @JvmName("setBusValue")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    fun onClick(@IdRes viewId: Int, block: (View) -> Unit = {}) {
        fragment?.view?.findViewById<View>(viewId)?.setOnClickListener {
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
        return childFragmentManager?.run {
            block(this)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Fragment> findFragmentByTag(tag: String?) = childFragmentManager?.findFragmentByTag(tag) as? T

    override fun existsFragmentWithTag(tag: String?) = findFragmentByTag<Fragment>(tag) != null

    override fun <T : Fragment> withFragmentByTag(tag: String?, block: T.(fragmentManager: FragmentManager) -> Unit): Unit? {
        return findFragmentByTag<T>(tag)?.run {
            block(this, childFragmentManager)
        }
    }

    override fun withFragmentTransaction(block: FragmentTransaction.() -> Unit): Unit? {
        return block(childFragmentManager?.beginTransaction() ?: return null)
    }
}
