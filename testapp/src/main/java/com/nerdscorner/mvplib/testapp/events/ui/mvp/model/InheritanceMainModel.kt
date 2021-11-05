package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import android.util.Log
import com.nerdscorner.events.coroutines.extensions.launch
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.testapp.events.networking.ExampleService
import com.nerdscorner.mvplib.testapp.events.networking.ServiceGenerator
import kotlinx.coroutines.Job

class InheritanceMainModel : BaseEventsModel() {

    private var fetchJob: Job? = null
    private val exampleService = ServiceGenerator.createService(ExampleService::class.java)

    fun doSomethingInBackground() {
        fetchJob?.cancel()
        fetchJob = launch(
            resultFunc = {
                exampleService.getExamplePageWithParams("someParam")
            },
            success = {
                bus.post(BackgroundTaskCompletedEvent(this))
            },
            fail = {
                bus.post(BackgroundTaskFailedEvent(message))
            },
            cancelled = {
                Log.e("InheritanceMainModel", "CANCELLED")
            }
        )
    }

    fun cancelJob() {
        fetchJob?.cancel()
    }

    class BackgroundTaskCompletedEvent(val pageHtml: String?)
    class BackgroundTaskFailedEvent(val message: String?)
}
