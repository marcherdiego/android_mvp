package com.nerdscorner.mvplib.testapp.events.attribute.activities.view

import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class AttributeMainView(activity: AppCompatActivity, bus: Bus) : BaseActivityView(activity, bus) {
    @BindView(R.id.text)
    @JvmField
    var textView: TextView? = null

    init {
        ButterKnife.bind(this, activity)
    }

    @OnClick(R.id.some_button)
    fun onActionClicked() {
        bus.post(ActionClickedEvent())
    }

    fun setTextValue(value: CharSequence) {
        textView!!.text = value
    }

    class ActionClickedEvent
}
