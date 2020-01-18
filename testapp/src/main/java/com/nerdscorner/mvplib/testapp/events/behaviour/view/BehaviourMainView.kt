package com.nerdscorner.mvplib.testapp.events.behaviour.view

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class BehaviourMainView(activity: AppCompatActivity) : BaseActivityView(activity) {
    var textView: TextView = activity.findViewById(R.id.text)

    init {
        onClick(R.id.some_button, ActionClickedEvent())
    }

    fun setTextValue(value: CharSequence) {
        textView.text = value
    }

    class ActionClickedEvent
}
