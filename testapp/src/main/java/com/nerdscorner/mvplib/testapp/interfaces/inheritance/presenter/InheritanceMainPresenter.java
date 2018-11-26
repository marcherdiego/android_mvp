package com.nerdscorner.mvplib.testapp.interfaces.inheritance.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.model.InheritanceMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.view.InheritanceMainView;

public class InheritanceMainPresenter extends BaseActivityPresenter<InheritanceMainView, InheritanceMainModel> implements InheritanceMainPresenterInterface {

    public InheritanceMainPresenter(InheritanceMainView view, InheritanceMainModel model) {
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
