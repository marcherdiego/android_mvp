package com.nerdscorner.mvplib.testapp.events.attribute.activities.presenter;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.events.attribute.activities.model.AttributeMainModel;
import com.nerdscorner.mvplib.testapp.events.attribute.activities.model.AttributeMainModel.BackgroundTaskCompletedEvent;
import com.nerdscorner.mvplib.testapp.events.attribute.activities.view.AttributeMainView;
import com.nerdscorner.mvplib.testapp.events.attribute.activities.view.AttributeMainView.ActionClickedEvent;

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
