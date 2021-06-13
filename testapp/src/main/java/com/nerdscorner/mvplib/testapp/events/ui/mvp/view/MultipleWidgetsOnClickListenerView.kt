package com.nerdscorner.mvplib.testapp.events.ui.mvp.view

import android.widget.Button
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.activities.MultipleWidgetsOnClickListenerActivity

class MultipleWidgetsOnClickListenerView(activity: MultipleWidgetsOnClickListenerActivity) : BaseActivityView(activity) {
    private val button4: Button = activity.findViewById(R.id.button_4)
    private val button5: Button = activity.findViewById(R.id.button_5)
    private val button6: Button = activity.findViewById(R.id.button_6)
    private val button7: Button = activity.findViewById(R.id.button_7)

    init {
        onClickView<Button>(R.id.button_1, R.id.button_2) { view ->
            bus.post(ButtonClickedEvent(view.text.toString()))
        }

        onClick(R.id.button_3, ButtonClickedEvent("Button 3"))

        onClick(button4, ButtonClickedEvent(button4.text.toString()))

        onClickView(button5, button6, button7) { view ->
            bus.post(ButtonClickedEvent(view.text.toString()))
        }
    }

    class ButtonClickedEvent(val text: String)
}
