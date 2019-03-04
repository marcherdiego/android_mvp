package com.nerdscorner.mvplib.testapp.events.attribute.fragments

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.AttributeFragmentMainModel
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter.AttributeForFragmentMainPresenter
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.AttributeFragmentMainView

class AttributeEventsForFragmentsMainActivity : AppCompatActivity() {

    private lateinit var presenter: AttributeForFragmentMainPresenter
    private lateinit var bus: Bus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_for_fragments)

        bus = Bus.newEventBus
        presenter = AttributeForFragmentMainPresenter(
                AttributeFragmentMainView(this, bus),
                AttributeFragmentMainModel(bus),
                bus
        )
    }

    override fun onResume() {
        super.onResume()
        bus.register(presenter)
    }

    override fun onPause() {
        bus.unregister(presenter)
        super.onPause()
    }

    override fun onBackPressed() {
        super.onBackPressed()

        //Do something here
        presenter.onBackPressed()
    }
}
