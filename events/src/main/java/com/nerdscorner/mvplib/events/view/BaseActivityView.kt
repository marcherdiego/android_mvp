package com.nerdscorner.mvplib.events.view

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import com.nerdscorner.mvplib.events.bus.Bus
import java.lang.ref.WeakReference

abstract class BaseActivityView @JvmOverloads constructor(
        activity: AppCompatActivity,
        @JvmField protected var bus: Bus = Bus.defaultBus
) : BaseView() {

    override val activity: AppCompatActivity?
        get() = activityRef.get()

    private val activityRef: WeakReference<AppCompatActivity> = WeakReference(activity)

    val fragmentManager: FragmentManager?
        get() {
            return activityRef.get()?.supportFragmentManager
        }

    @JvmName("busSetter")
    fun setBus(bus: Bus) {
        this.bus = bus
    }

    fun onDestroy() {}
}
