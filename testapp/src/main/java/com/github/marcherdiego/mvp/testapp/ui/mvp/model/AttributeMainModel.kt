package com.github.marcherdiego.mvp.testapp.ui.mvp.model

import com.github.marcherdiego.mvp.coroutines.extensions.runAsync

import com.github.marcherdiego.mvp.events.bus.Bus
import com.github.marcherdiego.mvp.events.model.BaseEventsModel
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
            post(BackgroundTaskCompletedEvent(result))
        }
    }

    private suspend fun fetchDataAsync(): String {
        //Fake heavy work
        delay(1000L)
        return "Some important data"
    }

    class BackgroundTaskCompletedEvent(val data: String)
}
