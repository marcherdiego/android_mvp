package com.github.marcherdiego.mvp.testapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.testapp.R
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.AttributeFragmentMainModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.presenter.AttributeForFragmentMainPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.AttributeFragmentMainView

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
