package com.nerdscorner.mvplib.testapp.events.ui.mvp.view

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class AttributeFragmentMainView(activity: AppCompatActivity, bus: Bus) :
        BaseActivityView(activity, bus) {

    init {
        onClick(R.id.next_fragment_btn, NextFragmentClickedEvent())
    }

    fun setCurrentFragment(nextFragment: Fragment) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, nextFragment)
        fragmentTransaction?.commitNow()
    }

    class NextFragmentClickedEvent
}
