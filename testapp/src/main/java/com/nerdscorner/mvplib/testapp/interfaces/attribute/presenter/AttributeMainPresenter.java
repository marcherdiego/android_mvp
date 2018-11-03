package com.nerdscorner.mvplib.testapp.interfaces.attribute.presenter;

import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.model.AttributeMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.view.AttributeMainView;

public class AttributeMainPresenter extends BaseActivityPresenter<AttributeMainView, AttributeMainModel>{

    public AttributeMainPresenter(AttributeMainView view, AttributeMainModel model) {
        super(view, model);
    }

    public void onActionClicked() {
        model.doSomethingInBackground();
    }

    public void onBackgroundTaskCompleted() {
        view.setTextValue("Background task completed");
    }
}
