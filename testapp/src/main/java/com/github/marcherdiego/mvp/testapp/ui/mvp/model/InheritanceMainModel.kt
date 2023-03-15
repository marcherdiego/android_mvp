package com.github.marcherdiego.mvp.testapp.ui.mvp.model

import android.util.Log
import com.github.marcherdiego.mvp.coroutines.extensions.launch
import com.github.marcherdiego.mvp.events.model.BaseEventsModel
import com.github.marcherdiego.mvp.testapp.networking.ExampleService
import com.github.marcherdiego.mvp.testapp.networking.ServiceGenerator
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
