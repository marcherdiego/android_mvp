package com.nerdscorner.mvplib.events.view

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.nerdscorner.mvplib.events.bus.Bus
import java.lang.ref.WeakReference

abstract class BaseFragmentView @JvmOverloads constructor(
        fragment: Fragment,
        @JvmField protected var bus: Bus = Bus.defaultBus
) : BaseView() {

    private var fragmentRef: WeakReference<Fragment> = WeakReference(fragment)

    override val activity: Activity?
        get() = fragmentRef.get()?.activity

    val fragmentManager: FragmentManager?
        get() {
            return fragmentRef.get()?.activity?.supportFragmentManager
        }

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
}
