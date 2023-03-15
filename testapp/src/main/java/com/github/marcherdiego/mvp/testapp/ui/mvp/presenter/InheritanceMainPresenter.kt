package com.github.marcherdiego.mvp.testapp.ui.mvp.presenter

import android.Manifest
import android.widget.Toast
import com.github.marcherdiego.mvp.coroutines.extensions.postDelayed
import com.github.marcherdiego.mvp.events.presenter.BaseActivityPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.InheritanceMainModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.InheritanceMainModel.BackgroundTaskCompletedEvent
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.InheritanceMainModel.BackgroundTaskFailedEvent
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.InheritanceMainView
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.InheritanceMainView.ActionClickedEvent
import org.greenrobot.eventbus.Subscribe

class InheritanceMainPresenter(view: InheritanceMainView, model: InheritanceMainModel) :
    BaseActivityPresenter<InheritanceMainView, InheritanceMainModel>(view, model) {

    init {
        postDelayed(100L) {
            withPermissions(
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.READ_EXTERNAL_STORAGE),
                onGranted = {
                    Toast.makeText(view.activity, "ACCESS_FINE_LOCATION and READ_EXTERNAL_STORAGE Granted!", Toast.LENGTH_SHORT).show()
                },
                onDenied = { list ->
                    Toast.makeText(view.activity, "Permissions ${list.joinToString()} Denied :(", Toast.LENGTH_SHORT).show()
                }
            )
        }
    }

    @Subscribe
    fun onActionClicked(event: ActionClickedEvent) {
        view.setTextValue("Executing background task...")
        model.doSomethingInBackground()
    }

    @Subscribe
    fun onBackgroundTaskCompleted(event: BackgroundTaskCompletedEvent) {
        val pageHtml = event.pageHtml ?: return
        view.loadPageHtml(pageHtml)
    }

    @Subscribe
    fun onBackgroundTaskFailed(event: BackgroundTaskFailedEvent) {
        view.setTextValue("Background task failed with message: ${event.message}")
    }

    override fun onPause() {
        super.onPause()
        model.cancelJob()
    }
}
