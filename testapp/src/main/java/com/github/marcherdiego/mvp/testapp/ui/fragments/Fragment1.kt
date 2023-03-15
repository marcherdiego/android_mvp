package com.github.marcherdiego.mvp.testapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.fragment.BaseFragment
import com.github.marcherdiego.mvp.testapp.R.layout
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.Fragment1Model
import com.github.marcherdiego.mvp.testapp.ui.mvp.presenter.Fragment1Presenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.Fragment1View

class Fragment1 : BaseFragment<Fragment1Presenter>() {

    private lateinit var bus: Bus

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layout.fragment_example, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bus = Bus.newInstance
        presenter = Fragment1Presenter(
            Fragment1View(this),
            Fragment1Model(),
            bus
        )
    }
}
