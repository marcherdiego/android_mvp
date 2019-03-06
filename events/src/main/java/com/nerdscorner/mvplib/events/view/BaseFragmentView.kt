package com.nerdscorner.mvplib.events.view

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.nerdscorner.mvplib.commons.mvp.view.BaseView
import com.nerdscorner.mvplib.events.bus.Bus
import java.lang.ref.WeakReference

abstract class BaseFragmentView : BaseView {

    private var fragmentRef: WeakReference<Fragment>? = null
    var bus: Bus

    override val activity: Activity?
        get() = getActivity()

    val fragmentManager: FragmentManager?
        get() {
            return fragmentRef?.get()?.activity?.supportFragmentManager
        }

    val context: Context?
        get() = fragmentRef?.get()?.context

    val fragment: Fragment?
        get() = fragmentRef?.get()

    fun getActivity(): FragmentActivity? {
        return fragmentRef?.get()?.activity
    }

    constructor(fragment: Fragment) {
        fragmentRef = WeakReference(fragment)
        bus = Bus.defaultBus
    }

    constructor(fragment: Fragment, bus: Bus) {
        fragmentRef = WeakReference(fragment)
        this.bus = bus
    }
}
