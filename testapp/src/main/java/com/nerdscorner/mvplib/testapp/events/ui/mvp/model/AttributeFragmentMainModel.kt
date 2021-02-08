package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel

class AttributeFragmentMainModel(bus: Bus) : BaseEventsModel(bus) {

    private var currentState = STATE_2

    val nextState: Int
        get() {
            when (currentState) {
                STATE_1 -> currentState = STATE_2
                STATE_2 -> currentState = STATE_1
            }
            return currentState
        }

    companion object {
        const val STATE_1 = 1
        const val STATE_2 = 2
    }
}
