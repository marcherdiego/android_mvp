package com.nerdscorner.mvplib.testapp.interfaces.attribute.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.model.AttributeMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.view.AttributeMainView;

public class AttributeMainPresenter extends BaseActivityPresenter<AttributeMainView, AttributeMainModel> implements AttributeMainPresenterInterface {

    public AttributeMainPresenter(AttributeMainView view, AttributeMainModel model) {
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
