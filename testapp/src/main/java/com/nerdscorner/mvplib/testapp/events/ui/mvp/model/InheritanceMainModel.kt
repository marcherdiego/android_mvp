package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import android.util.Log
import com.nerdscorner.events.coroutines.extensions.withResult

import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.testapp.events.networking.ExampleService
import com.nerdscorner.mvplib.testapp.events.networking.ServiceGenerator
import kotlinx.coroutines.Job

class InheritanceMainModel : BaseEventsModel() {

    private var fetchJob: Job? = null
    private val wikiService = ServiceGenerator.createService(ExampleService::class.java)

    fun doSomethingInBackground() {
        fetchJob?.cancel()
        fetchJob = withResult(
                resultFunc = wikiService::getWikipedia,
                success = {
                    bus.post(BackgroundTaskCompletedEvent(this))
                },
                fail = {
                    bus.post(BackgroundTaskFailedEvent(this.message))
                },
                cancelled = {
                    Log.e("InheritanceMainModel", "CANCELLED")
                }
        )
    }

    fun cancelJob() {
        fetchJob?.cancel()
    }

    class BackgroundTaskCompletedEvent(val data: String?)
    class BackgroundTaskFailedEvent(val message: String?)
}
