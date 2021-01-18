package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter
import com.nerdscorner.mvplib.testapp.events.ui.fragments.Fragment1
import com.nerdscorner.mvplib.testapp.events.ui.fragments.Fragment2
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.AttributeFragmentMainModel
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.AttributeFragmentMainView
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.AttributeFragmentMainView.NextFragmentClickedEvent

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
        val fragment = when (val nextFragment = model.nextFragment) {
            AttributeFragmentMainModel.FRAGMENT_1 -> Fragment1()
            AttributeFragmentMainModel.FRAGMENT_2 -> Fragment2()
            else -> throw IllegalArgumentException("Invalid fragment code: $nextFragment")
        }
        view.setCurrentFragment(fragment)
    }

}
