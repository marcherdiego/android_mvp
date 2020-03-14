package com.nerdscorner.mvplib.testapp.events.inheritance.fragments.view

import android.widget.TextView
import androidx.fragment.app.Fragment
import com.nerdscorner.mvplib.events.view.BaseFragmentView
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.attribute.activities.view.AttributeMainView.ActionClickedEvent

class Fragment2View(fragment: Fragment) : BaseFragmentView(fragment) {
    var textView: TextView? = fragment.view?.findViewById(R.id.text)

    init {
        onClick(R.id.some_button, ActionClickedEvent())
    }

    fun setText(value: String) {
        textView?.text = value
    }
}
