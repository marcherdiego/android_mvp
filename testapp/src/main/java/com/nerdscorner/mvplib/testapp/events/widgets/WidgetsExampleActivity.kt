package com.nerdscorner.mvplib.testapp.events.widgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.nerdscorner.mvplib.testapp.R

class WidgetsExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgets_example)

        val sampleWidget = SampleWidget(this)
        findViewById<LinearLayout>(R.id.root_view).addView(sampleWidget)
    }
}
