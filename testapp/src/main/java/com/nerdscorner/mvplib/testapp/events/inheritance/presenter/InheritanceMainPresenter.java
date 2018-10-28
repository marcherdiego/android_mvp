package com.nerdscorner.mvplib.testapp.events.inheritance.presenter;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.events.inheritance.model.InheritanceMainModel;
import com.nerdscorner.mvplib.testapp.events.inheritance.model.InheritanceMainModel.BackgroundTaskCompletedEvent;
import com.nerdscorner.mvplib.testapp.events.inheritance.view.InheritanceMainView;
import com.nerdscorner.mvplib.testapp.events.inheritance.view.InheritanceMainView.ActionClickedEvent;

import org.greenrobot.eventbus.Subscribe;

public class InheritanceMainPresenter extends BaseActivityPresenter<InheritanceMainView, InheritanceMainModel> {

    public InheritanceMainPresenter(InheritanceMainView view, InheritanceMainModel model) {
        super(view, model);
    }

    @Subscribe
    public void onActionClicked(ActionClickedEvent event) {
        model.doSomethingInBackground();
    }

    @Subscribe
    public void onBackgroundTaskCompleted(BackgroundTaskCompletedEvent event) {
        view.setTextValue("Background task completed");
    }
}
