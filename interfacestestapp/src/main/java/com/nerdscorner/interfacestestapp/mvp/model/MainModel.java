package com.nerdscorner.interfacestestapp.mvp.model;

import android.os.AsyncTask;

import com.nerdscorner.interfacestestapp.mvp.presenter.MainPresenter;
import com.nerdscorner.mvplib.interfaces.model.BaseModel;

public class MainModel extends BaseModel<MainPresenter> implements MainModelInterface {

    @Override
    public void doSomethingInBackground() {
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... voids) {
                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                presenter.onBackgroundTaskCompleted();
            }
        }.execute();
    }
}
