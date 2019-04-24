package com.nerdscorner.mvplib.testapp.events.attribute.fragments.view

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.OnClick
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class AttributeFragmentMainView(activity: AppCompatActivity, bus: Bus) :
        BaseActivityView(activity, bus) {

    init {
        ButterKnife.bind(this, activity)
    }

    @OnClick(R.id.next_fragment_btn)
    fun onNextFragmentClicked() {
        bus.post(NextFragmentClickedEvent())
    }

    fun setCurrentFragment(nextFragment: Fragment) {
        val fragmentTransaction = fragmentManager?.beginTransaction()
        fragmentTransaction?.replace(R.id.container, nextFragment)
        fragmentTransaction?.commitNow()
    }

    class NextFragmentClickedEvent
}
