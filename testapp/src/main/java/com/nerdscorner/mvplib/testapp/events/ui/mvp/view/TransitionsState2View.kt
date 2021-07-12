package com.nerdscorner.mvplib.testapp.events.ui.mvp.view

import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.activities.TransitionsState2Activity

class TransitionsState2View(activity: TransitionsState2Activity) : BaseActivityView(activity) {
    init {
        onClick(R.id.button, Transition3ButtonClickedEvent())
    }

    class Transition3ButtonClickedEvent
}
