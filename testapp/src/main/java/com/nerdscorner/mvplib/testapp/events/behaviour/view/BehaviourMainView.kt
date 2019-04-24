package com.nerdscorner.mvplib.testapp.events.behaviour.view

import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.testapp.R

class BehaviourMainView(activity: AppCompatActivity) : BaseActivityView(activity) {
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
        textView?.text = value
    }

    class ActionClickedEvent
}
