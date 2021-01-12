package com.nerdscorner.mvplib.testapp.events.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.widgets.SampleWidget

class WidgetsExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgets_example)

        val sampleWidget = SampleWidget(this)
        findViewById<LinearLayout>(R.id.root_view).addView(sampleWidget)
    }
}
