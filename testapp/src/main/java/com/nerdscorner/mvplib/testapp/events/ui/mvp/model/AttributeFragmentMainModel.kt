package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel

class AttributeFragmentMainModel(bus: Bus) : BaseEventsModel(bus) {

    private var currentFragment = FRAGMENT_2

    val nextFragment: Int
        get() {
            when (currentFragment) {
                FRAGMENT_1 -> currentFragment = FRAGMENT_2
                FRAGMENT_2 -> currentFragment = FRAGMENT_1
            }
            return currentFragment
        }

    companion object {
        const val FRAGMENT_1 = 1
        const val FRAGMENT_2 = 2
    }
}
