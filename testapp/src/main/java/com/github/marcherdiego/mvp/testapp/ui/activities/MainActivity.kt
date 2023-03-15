package com.github.marcherdiego.mvp.testapp.ui.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.github.marcherdiego.mvp.testapp.R.id
import com.github.marcherdiego.mvp.testapp.R.layout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        addListenerToView(id.events_attributes, AttributeEventsMainActivity::class.java)
        addListenerToView(id.events_inheritance, InheritanceEventsMainActivity::class.java)
        addListenerToView(id.multiple_on_click_showcase, MultipleWidgetsOnClickListenerActivity::class.java)

        addListenerToView(id.fragments_events_attribute, AttributeEventsForFragmentsMainActivity::class.java)

        addListenerToView(id.widgets_example, WidgetsExampleActivity::class.java)
    }

    private fun addListenerToView(@IdRes viewId: Int, destination: Class<*>) {
        findViewById<View>(viewId).setOnClickListener { startActivity(Intent(applicationContext, destination)) }
    }
}
