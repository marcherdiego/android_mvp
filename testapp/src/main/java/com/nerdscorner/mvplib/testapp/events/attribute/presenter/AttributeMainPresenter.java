package com.nerdscorner.mvplib.testapp.events.attribute.presenter;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.events.attribute.model.AttributeMainModel;
import com.nerdscorner.mvplib.testapp.events.attribute.model.AttributeMainModel.BackgroundTaskCompletedEvent;
import com.nerdscorner.mvplib.testapp.events.attribute.view.AttributeMainView;
import com.nerdscorner.mvplib.testapp.events.attribute.view.AttributeMainView.ActionClickedEvent;

import org.greenrobot.eventbus.Subscribe;

public class AttributeMainPresenter extends BaseActivityPresenter<AttributeMainView, AttributeMainModel> {

    public AttributeMainPresenter(AttributeMainView view, AttributeMainModel model) {
        super(view, model);
    }

    @Subscribe
    public void onActionClicked(ActionClickedEvent event) {
        view.setTextValue("Executing background task...");
        model.doSomethingInBackground();
    }

    @Subscribe
    public void onBackgroundTaskCompleted(BackgroundTaskCompletedEvent event) {
        view.setTextValue("Background task completed");
    }
}
