package com.nerdscorner.mvplib.testapp.events.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.fragment.BaseFragment
import com.nerdscorner.mvplib.testapp.R.layout
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.Fragment1Model
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.Fragment1Presenter
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.Fragment1View

class Fragment1 : BaseFragment<Fragment1Presenter>() {

    private lateinit var bus: Bus

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.fragment_example, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bus = Bus.newInstance
        presenter = Fragment1Presenter(
                Fragment1View(this),
                Fragment1Model(),
                bus
        )
    }
}
