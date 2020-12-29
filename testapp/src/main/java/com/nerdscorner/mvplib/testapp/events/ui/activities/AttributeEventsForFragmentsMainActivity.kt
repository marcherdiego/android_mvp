package com.nerdscorner.mvplib.testapp.events.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.AttributeFragmentMainModel
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.AttributeForFragmentMainPresenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.AttributeFragmentMainView

class AttributeEventsForFragmentsMainActivity : AppCompatActivity() {

    private lateinit var presenter: AttributeForFragmentMainPresenter
    private lateinit var bus: Bus

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp_for_fragments)

        bus = Bus.newInstance
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
