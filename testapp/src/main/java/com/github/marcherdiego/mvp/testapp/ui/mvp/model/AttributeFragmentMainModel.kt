package com.github.marcherdiego.mvp.testapp.ui.mvp.model

import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.model.BaseEventsModel

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
