package com.nerdscorner.mvplib.testapp.interfaces.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.model.MainModel;
import com.nerdscorner.mvplib.testapp.interfaces.view.MainView;

public class MainPresenter extends BaseActivityPresenter<MainView, MainModel> implements MainPresenterInterface {

    public MainPresenter(MainView view, MainModel model) {
        super(view, model);
    }

    @Override
    public void onActionClicked() {
        model.doSomethingInBackground();
    }

    @Override
    public void onBackgroundTaskCompleted() {
        view.setTextValue("Background task completed");
    }
}
