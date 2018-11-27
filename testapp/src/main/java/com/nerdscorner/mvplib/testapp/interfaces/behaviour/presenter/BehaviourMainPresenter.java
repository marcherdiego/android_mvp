package com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.model.BehaviourMainModelInterface;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.view.BehaviourMainViewInterface;

public class BehaviourMainPresenter extends BaseActivityPresenter<BehaviourMainViewInterface, BehaviourMainModelInterface> implements BehaviourMainPresenterInterface {

    public BehaviourMainPresenter(BehaviourMainViewInterface view, BehaviourMainModelInterface model) {
        super(view, model);
    }

    @Override
    public void onActionClicked() {
        view.setTextValue("Executing background task...");
        model.doSomethingInBackground();
    }

    @Override
    public void onBackgroundTaskCompleted() {
        view.setTextValue("Background task completed");
    }
}
