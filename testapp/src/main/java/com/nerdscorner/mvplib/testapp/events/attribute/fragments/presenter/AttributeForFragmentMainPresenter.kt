package com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter


import androidx.fragment.app.Fragment
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.Fragment1
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.Fragment2
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.AttributeFragmentMainModel
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.AttributeFragmentMainView
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.AttributeFragmentMainView.NextFragmentClickedEvent

import org.greenrobot.eventbus.Subscribe

class AttributeForFragmentMainPresenter(
        view: AttributeFragmentMainView,
        model: AttributeFragmentMainModel, bus: Bus
) : BaseActivityPresenter<AttributeFragmentMainView, AttributeFragmentMainModel>(view, model, bus) {

    init {
        //Just so we can show the fragment 1 when the view is created
        onNextFragmentClicked(null)
    }

    @Subscribe
    fun onNextFragmentClicked(event: NextFragmentClickedEvent?) {
        val nextFragment = model.nextFragment
        val fragment: Fragment
        when (nextFragment) {
            AttributeFragmentMainModel.FRAGMENT_1 -> fragment = Fragment1()
            AttributeFragmentMainModel.FRAGMENT_2 -> fragment = Fragment2()
            else -> throw IllegalArgumentException("Invalid fragment code: $nextFragment")
        }
        view.setCurrentFragment(fragment)
    }

}
