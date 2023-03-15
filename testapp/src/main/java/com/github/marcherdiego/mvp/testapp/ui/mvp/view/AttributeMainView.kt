package com.github.marcherdiego.mvp.testapp.ui.mvp.view

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.view.BaseActivityView
import com.github.marcherdiego.mvp.testapp.R

class AttributeMainView(activity: AppCompatActivity, bus: Bus) : BaseActivityView(activity, bus) {
    private var textView: TextView = activity.findViewById(R.id.text)

    init {
        onClick(R.id.some_button, ActionClickedEvent())
    }

    fun setTextValue(value: CharSequence) {
        textView.text = value
    }

    class ActionClickedEvent
}
