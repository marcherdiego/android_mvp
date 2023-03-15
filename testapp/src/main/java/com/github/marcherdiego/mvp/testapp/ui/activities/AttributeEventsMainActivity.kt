package com.github.marcherdiego.mvp.testapp.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.testapp.R
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.AttributeMainModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.presenter.AttributeMainPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.AttributeMainView

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
