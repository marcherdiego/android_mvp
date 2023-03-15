package com.github.marcherdiego.mvp.testapp.ui.mvp.view

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.view.BaseActivityView
import com.github.marcherdiego.mvp.testapp.R

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
