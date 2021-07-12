package com.nerdscorner.mvplib.testapp.events.ui.mvp.view

import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.activities.TransitionsState1Activity

class TransitionsState1View(activity: TransitionsState1Activity) : BaseActivityView(activity) {
    init {
        onClick(R.id.button, Transition1ButtonClickedEvent())
        onClick(R.id.button_3, Transition3ButtonClickedEvent())
    }

    class Transition1ButtonClickedEvent
    class Transition3ButtonClickedEvent
}
