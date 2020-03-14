package com.nerdscorner.mvplib.testapp.events.inheritance.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.fragment.BaseFragment
import com.nerdscorner.mvplib.testapp.R.layout
import com.nerdscorner.mvplib.testapp.events.inheritance.fragments.model.Fragment2Model
import com.nerdscorner.mvplib.testapp.events.inheritance.fragments.presenter.Fragment2Presenter
import com.nerdscorner.mvplib.testapp.events.inheritance.fragments.view.Fragment2View

class Fragment2 : BaseFragment<Fragment2Presenter>() {

    private lateinit var bus: Bus

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.fragment_example, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        bus = Bus.newInstance
        presenter = Fragment2Presenter(
                Fragment2View(this),
                Fragment2Model(),
                bus
        )
    }
}
