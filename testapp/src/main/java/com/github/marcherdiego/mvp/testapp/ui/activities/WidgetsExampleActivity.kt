package com.github.marcherdiego.mvp.testapp.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.github.marcherdiego.mvp.testapp.R
import com.github.marcherdiego.mvp.testapp.ui.widgets.SampleWidget

class WidgetsExampleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_widgets_example)

        val sampleWidget = SampleWidget(this)
        findViewById<LinearLayout>(R.id.root_view).addView(sampleWidget)
    }
}
