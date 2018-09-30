package com.nerdscorner.mvplib.testapp.events.attribute.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.model.BaseEventsModel;

public class AttributeMainModel extends BaseEventsModel {

    public AttributeMainModel(Bus bus) {
        super(bus);
    }

    public void doSomethingInBackground() {
        new SomeBackgroundTask(this).execute();
    }

    private static class SomeBackgroundTask extends AsyncTask<Void, Void, Void> {
        private AttributeMainModel model;

        SomeBackgroundTask(AttributeMainModel model) {
            this.model = model;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            model.getBus().post(new BackgroundTaskCompletedEvent());
        }
    }

    public static class BackgroundTaskCompletedEvent {
    }
}
