package com.nerdscorner.mvplib.testapp.interfaces.attribute.model;

import android.os.AsyncTask;

import com.nerdscorner.mvplib.interfaces.model.BaseInterfacesModel;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.presenter.AttributeMainPresenterInterface;

public class AttributeMainModel extends BaseInterfacesModel<AttributeMainPresenterInterface> implements AttributeMainModelInterface {

    @Override
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
            model.getPresenter().onBackgroundTaskCompleted();
        }
    }
}
