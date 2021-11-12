package com.nerdscorner.mvplib.testapp.events.ui.mvp.view

import android.os.Build
import android.text.Html
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class InheritanceMainView(activity: AppCompatActivity) : BaseActivityView(activity) {
    private var textView: TextView = activity.findViewById(R.id.text)

    init {
        onClick(R.id.some_button, R.id.some_button, event = ActionClickedEvent())
    }

    fun setTextValue(value: CharSequence) {
        textView.text = value
    }

    fun loadPageHtml(pageHtml: String?) {
        textView.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(pageHtml, Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(pageHtml)
        }
    }

    class ActionClickedEvent
}
