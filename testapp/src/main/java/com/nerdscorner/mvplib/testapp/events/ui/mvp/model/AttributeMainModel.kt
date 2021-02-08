package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import com.nerdscorner.events.coroutines.extensions.runAsync

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class AttributeMainModel(bus: Bus) : BaseEventsModel(bus) {

    fun doSomethingInBackground() {
        CoroutineScope(Dispatchers.Main).launch {
            val deferredResult = runAsync {
                fetchDataAsync()
            }
            val result = deferredResult.await()
            bus.post(BackgroundTaskCompletedEvent(result))
        }
    }

    private suspend fun fetchDataAsync(): String {
        //Fake heavy work
        delay(1000L)
        return "Some important data"
    }

    class BackgroundTaskCompletedEvent(val data: String)
}
