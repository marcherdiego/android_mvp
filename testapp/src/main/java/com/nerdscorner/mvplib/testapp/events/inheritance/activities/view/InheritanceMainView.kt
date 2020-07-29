package com.nerdscorner.mvplib.testapp.events.inheritance.activities.view

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class InheritanceMainView(activity: AppCompatActivity) : BaseActivityView(activity) {
    var textView: TextView = activity.findViewById(R.id.text)

    init {
        onClick(R.id.some_button, R.id.some_button, event = ActionClickedEvent())
    }

    fun setTextValue(value: CharSequence) {
        textView.text = value
    }

    class ActionClickedEvent
}
