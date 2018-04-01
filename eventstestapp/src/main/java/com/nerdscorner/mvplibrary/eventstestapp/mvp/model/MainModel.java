package com.nerdscorner.mvplibrary.eventstestapp.mvp.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.events.model.BaseModel;

public class MainModel extends BaseModel {
    public void doSomethingInBackground() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                bus.post(new BackgroundTaskCompletedEvent());
            }
        }.execute();
    }

    public static class BackgroundTaskCompletedEvent {
    }
}
