package com.nerdscorner.mvplib.testapp.interfaces.inheritance.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.model.InheritanceMainModelInterface;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.view.InheritanceMainViewInterface;

public class InheritanceMainPresenter extends BaseActivityPresenter<InheritanceMainViewInterface, InheritanceMainModelInterface> implements InheritanceMainPresenterInterface {

    public InheritanceMainPresenter(InheritanceMainViewInterface view, InheritanceMainModelInterface model) {
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
