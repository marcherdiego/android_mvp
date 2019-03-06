package com.nerdscorner.mvplib.testapp.events.attribute.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.ButterKnife
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.testapp.R
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.Fragment1Model
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter.Fragment1Presenter
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.Fragment1View

class Fragment1 : Fragment() {

    private lateinit var presenter: Fragment1Presenter
    private lateinit var bus: Bus

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_example, container, false)
        ButterKnife.bind(this, view)
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bus = Bus.newInstance
        presenter = Fragment1Presenter(
                Fragment1View(this, bus),
                Fragment1Model(bus)
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