package com.nerdscorner.interfacestestapp.mvp.model.implementations;

import android.os.AsyncTask;

import com.nerdscorner.interfacestestapp.mvp.model.interfaces.MainModelInterface;
import com.nerdscorner.interfacestestapp.mvp.presenter.implementations.MainPresenter;
import com.nerdscorner.mvplib.interfaces.model.BaseModel;

public class MainModel extends BaseModel<MainPresenter> implements MainModelInterface {

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
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            model.getPresenter().onBackgroundTaskCompleted();
        }
    }
}
