package com.github.marcherdiego.mvp.testapp.ui.mvp.presenter

import android.Manifest
import android.widget.Toast
import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.presenter.BaseFragmentPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.Fragment1Model
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.Fragment1View

import org.greenrobot.eventbus.NoSubscriberEvent
import org.greenrobot.eventbus.Subscribe

class Fragment1Presenter(view: Fragment1View, model: Fragment1Model, bus: Bus) :
    BaseFragmentPresenter<Fragment1View, Fragment1Model>(view, model, bus) {
    init {
        view.setText("Fragment 1")

        withPermission(
                Manifest.permission.READ_EXTERNAL_STORAGE,
                onGranted = {
                    Toast.makeText(view.context, "READ_EXTERNAL_STORAGE Granted!", Toast.LENGTH_SHORT).show()
                },
                onDenied = {
                    Toast.makeText(view.context, "READ_EXTERNAL_STORAGE Denied :(", Toast.LENGTH_SHORT).show()
                }
        )
    }

    @Subscribe
    fun onNoSubscriber(event: NoSubscriberEvent) {
    }
}
