package com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.model.MainModel;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.view.MainView;

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
