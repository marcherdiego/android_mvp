package com.nerdscorner.mvplib.testapp

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import com.nerdscorner.mvplib.testapp.events.attribute.activities.AttributeEventsMainActivity
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.AttributeEventsForFragmentsMainActivity
import com.nerdscorner.mvplib.testapp.events.behaviour.BehaviourEventsMainActivity
import com.nerdscorner.mvplib.testapp.events.inheritance.InheritanceEventsMainActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addListenerToView(R.id.events_behaviour, BehaviourEventsMainActivity::class.java)
        addListenerToView(R.id.events_attributes, AttributeEventsMainActivity::class.java)
        addListenerToView(R.id.events_inheritance, InheritanceEventsMainActivity::class.java)

        addListenerToView(R.id.fragments_events_attribute, AttributeEventsForFragmentsMainActivity::class.java)
    }

    private fun addListenerToView(@IdRes viewId: Int, destination: Class<*>) {
        findViewById<View>(viewId).setOnClickListener { startActivity(Intent(applicationContext, destination)) }
    }
}
