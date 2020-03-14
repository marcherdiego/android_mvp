package com.nerdscorner.mvplib.testapp.events.attribute.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.attribute.activities.model.AttributeMainModel
import com.nerdscorner.mvplib.testapp.events.attribute.activities.presenter.AttributeMainPresenter
import com.nerdscorner.mvplib.testapp.events.attribute.activities.view.AttributeMainView

class AttributeEventsMainActivity : AppCompatActivity() {

    private lateinit var presenter: AttributeMainPresenter
    private var bus = Bus.newInstance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvp)

        presenter = AttributeMainPresenter(
                AttributeMainView(this, bus),
                AttributeMainModel(bus),
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
