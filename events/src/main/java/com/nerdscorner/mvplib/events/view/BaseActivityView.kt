package com.nerdscorner.mvplib.events.view

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity

import com.nerdscorner.mvplib.commons.mvp.view.BaseView
import com.nerdscorner.mvplib.events.bus.Bus

import java.lang.ref.WeakReference

abstract class BaseActivityView @JvmOverloads constructor(
        activity: AppCompatActivity,
        var bus: Bus = Bus.defaultEventBus
) : BaseView() {

    private val activityRef: WeakReference<AppCompatActivity> = WeakReference(activity)

    val fragmentManager: FragmentManager?
        get() {
            val activity = activity
            return activity?.supportFragmentManager
        }

    override fun getActivity(): AppCompatActivity? {
        return activityRef.get()
    }

    fun onDestroy() {}
}
