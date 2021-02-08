package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import android.util.Log
import com.nerdscorner.events.coroutines.extensions.withResult

import com.nerdscorner.mvplib.events.model.BaseEventsModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlin.random.Random

class InheritanceMainModel : BaseEventsModel() {

    private var fetchJob: Job? = null

    fun doSomethingInBackground() {
        fetchJob?.cancel()
        fetchJob = withResult(
                resultFunc = this::fetchDataAsync,
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

    private suspend fun fetchDataAsync(): String {
        //Fake heavy work
        delay(3000L)
        if (Random(System.currentTimeMillis()).nextBoolean()) {
            throw IllegalStateException("Random exception")
        }
        return "Some data"
    }

    fun cancelJob() {
        fetchJob?.cancel()
    }

    class BackgroundTaskCompletedEvent(val data: String?)
    class BackgroundTaskFailedEvent(val message: String?)
}
