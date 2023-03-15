package com.github.marcherdiego.mvp.testapp.ui.mvp.view

import android.widget.TextView
import androidx.fragment.app.Fragment
import com.github.marcherdiego.mvp.events.view.BaseFragmentView
import com.github.marcherdiego.mvp.testapp.R
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.AttributeMainView.ActionClickedEvent

class Fragment1View(fragment: Fragment) : BaseFragmentView(fragment) {
    private var textView: TextView? = fragment.view?.findViewById(R.id.text)

    init {
        onClick(R.id.some_button, ActionClickedEvent())
    }

    fun setText(value: String) {
        textView?.text = value
    }
}
