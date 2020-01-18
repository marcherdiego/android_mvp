package com.nerdscorner.mvplib.testapp.events.attribute.activities.view

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class AttributeMainView(activity: AppCompatActivity, bus: Bus) : BaseActivityView(activity, bus) {
    var textView: TextView = activity.findViewById(R.id.text)

    init {
        onClick(R.id.some_button, ActionClickedEvent())
    }

    fun setTextValue(value: CharSequence) {
        textView.text = value
    }

    class ActionClickedEvent
}
