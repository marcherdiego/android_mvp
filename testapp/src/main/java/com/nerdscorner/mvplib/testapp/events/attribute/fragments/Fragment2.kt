package com.nerdscorner.mvplib.testapp.events.attribute.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.Fragment2Model
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter.Fragment2Presenter
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.Fragment2View

class Fragment2 : Fragment() {

    private lateinit var presenter: Fragment2Presenter
    private lateinit var bus: Bus

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_example, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bus = Bus.newInstance
        presenter = Fragment2Presenter(
                Fragment2View(this, bus),
                Fragment2Model(bus)
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
}
