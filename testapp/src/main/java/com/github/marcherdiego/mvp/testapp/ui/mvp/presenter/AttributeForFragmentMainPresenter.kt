package com.github.marcherdiego.mvp.testapp.ui.mvp.presenter

import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.presenter.BaseActivityPresenter
import com.github.marcherdiego.mvp.testapp.ui.fragments.Fragment1
import com.github.marcherdiego.mvp.testapp.ui.fragments.Fragment2
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.AttributeFragmentMainModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.AttributeFragmentMainView
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.AttributeFragmentMainView.NextFragmentClickedEvent

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
        val fragment = when (val nextFragment = model.nextState) {
            AttributeFragmentMainModel.STATE_1 -> Fragment1()
            AttributeFragmentMainModel.STATE_2 -> Fragment2()
            else -> throw IllegalArgumentException("Invalid fragment code: $nextFragment")
        }
        view.setCurrentFragment(fragment)
    }

}
