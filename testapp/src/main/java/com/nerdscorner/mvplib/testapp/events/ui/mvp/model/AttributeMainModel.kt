package com.nerdscorner.mvplib.testapp.events.ui.mvp.model

import android.os.AsyncTask

import com.nerdscorner.mvplib.events.bus.Bus
import com.nerdscorner.mvplib.events.model.BaseEventsModel

class AttributeMainModel(bus: Bus) : BaseEventsModel(bus) {

    fun doSomethingInBackground() {
        SomeBackgroundTask(this).execute()
    }

    private class SomeBackgroundTask(private val model: AttributeMainModel) : AsyncTask<Void, Void, Void>() {

        override fun doInBackground(vararg voids: Void): Void? {
            try {
                Thread.sleep(1000L)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }

            return null
        }

        override fun onPostExecute(aVoid: Void?) {
            super.onPostExecute(aVoid)
            model.bus.post(BackgroundTaskCompletedEvent())
        }
    }

    class BackgroundTaskCompletedEvent
}
