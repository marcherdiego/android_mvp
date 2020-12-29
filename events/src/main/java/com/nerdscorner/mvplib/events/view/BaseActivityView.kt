package com.nerdscorner.mvplib.events.view

import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nerdscorner.mvplib.events.bus.Bus
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

    fun onClick(@IdRes id: Int, event: Any, threadMode: ThreadMode = ThreadMode.POSTING, block: (View) -> Unit = {}) {
        activity?.findViewById<View>(id)?.setOnClickListener {
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
            activity?.findViewById<View>(it)?.setOnClickListener(onClickListener)
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
            block(this, fragmentManager ?: return null)
        }
    }

    override fun withFragmentTransaction(block: FragmentTransaction.() -> Unit): Unit? {
        return block(fragmentManager?.beginTransaction() ?: return null)
    }
}
