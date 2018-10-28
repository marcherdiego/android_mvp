package com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.model.BehaviourMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.view.BehaviourMainView;

public class BehaviourMainPresenter extends BaseActivityPresenter<BehaviourMainView, BehaviourMainModel> implements BehaviourMainPresenterInterface {

    public BehaviourMainPresenter(BehaviourMainView view, BehaviourMainModel model) {
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
