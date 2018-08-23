package com.nerdscorner.mvplib.testapp.interfaces.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.interfaces.model.BaseInterfacesModel;
import com.nerdscorner.mvplib.testapp.interfaces.presenter.MainPresenter;

public class MainModel extends BaseInterfacesModel<MainPresenter> implements MainModelInterface {

    @Override
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
            model.getPresenter().onBackgroundTaskCompleted();
        }
    }

    public static class BackgroundTaskCompletedEvent {
    }
}
