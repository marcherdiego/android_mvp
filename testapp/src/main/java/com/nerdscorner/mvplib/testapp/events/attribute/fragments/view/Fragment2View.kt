package com.nerdscorner.mvplib.testapp.events.attribute.fragments.view

import android.support.v4.app.Fragment
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.view.BaseFragmentView
import com.nerdscorner.mvplib.testapp.R

class Fragment2View(fragment: Fragment, bus: Bus) : BaseFragmentView(fragment, bus) {
    @BindView(R.id.text)
    @JvmField
    var text: TextView? = null

    init {
        ButterKnife.bind(this, fragment.view!!)
    }

    fun setText(text: String) {
        this.text?.text = text
    }
}
