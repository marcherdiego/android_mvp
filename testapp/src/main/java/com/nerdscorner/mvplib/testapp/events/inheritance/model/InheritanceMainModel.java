package com.nerdscorner.mvplib.testapp.events.inheritance.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.events.model.BaseEventsModel;

public class InheritanceMainModel extends BaseEventsModel {

    public void doSomethingInBackground() {
        new SomeBackgroundTask(this).execute();
    }

    private static class SomeBackgroundTask extends AsyncTask<Void, Void, Void> {
        private InheritanceMainModel model;

        SomeBackgroundTask(InheritanceMainModel model) {
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
