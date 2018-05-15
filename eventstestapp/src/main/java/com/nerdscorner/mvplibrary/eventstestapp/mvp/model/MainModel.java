package com.nerdscorner.mvplibrary.eventstestapp.mvp.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.events.model.BaseModel;

public class MainModel extends BaseModel {
    public void doSomethingInBackground() {
        new SomeBackgroundTask(this).execute();
    }

    private static class SomeBackgroundTask extends AsyncTask<Void, Void, Void> {
        private MainModel model;

        SomeBackgroundTask(MainModel model) {
            this.model = model;
        }

        @Override
        protected Void doInBackground(Void... voids) {
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
