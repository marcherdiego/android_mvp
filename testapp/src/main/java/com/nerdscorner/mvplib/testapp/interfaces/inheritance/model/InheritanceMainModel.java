package com.nerdscorner.mvplib.testapp.interfaces.inheritance.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.interfaces.model.BaseInterfacesModel;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.presenter.InheritanceMainPresenter;

public class InheritanceMainModel extends BaseInterfacesModel<InheritanceMainPresenter> implements InheritanceMainModelInterface {

    @Override
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
            model.getPresenter().onBackgroundTaskCompleted();
        }
    }
}
