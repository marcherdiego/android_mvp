package com.nerdscorner.mvplib.events.view

import android.app.Activity
import android.content.Context
import android.view.View
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nerdscorner.mvplib.events.bus.Bus
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

    @JvmName("busSetter")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    fun onClick(@IdRes id: Int, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        fragment?.view?.findViewById<View>(id)?.setOnClickListener {
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
            fragment?.view?.findViewById<View>(it)?.setOnClickListener(onClickListener)
        }
    }

    override fun withFragmentManager(block: FragmentManager.() -> Unit): Unit? {
        return childFragmentManager?.run {
            block(this)
        }
    }

    override fun <T : Fragment> findFragmentByTag(tag: String) = childFragmentManager?.findFragmentByTag(tag) as? T

    override fun existsFragmentWithTag(tag: String) = findFragmentByTag<Fragment>(tag) != null

    override fun <T : Fragment> withFragmentByTag(tag: String, block: T.(fragmentManager: FragmentManager) -> Unit): Unit? {
        return findFragmentByTag<T>(tag)?.run {
            block(this, childFragmentManager)
        }
    }

    override fun withFragmentTransaction(block: FragmentTransaction.() -> Unit): Unit? {
        return block(childFragmentManager?.beginTransaction() ?: return null)
    }
}
