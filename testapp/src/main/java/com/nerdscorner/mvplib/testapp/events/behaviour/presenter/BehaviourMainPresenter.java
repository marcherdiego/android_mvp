package com.nerdscorner.mvplib.testapp.events.behaviour.presenter;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.testapp.events.behaviour.model.BehaviourMainModel;
import com.nerdscorner.mvplib.testapp.events.behaviour.model.BehaviourMainModel.BackgroundTaskCompletedEvent;
import com.nerdscorner.mvplib.testapp.events.behaviour.view.BehaviourMainView;
import com.nerdscorner.mvplib.testapp.events.behaviour.view.BehaviourMainView.ActionClickedEvent;

import org.greenrobot.eventbus.Subscribe;

public class BehaviourMainPresenter extends BaseActivityPresenter<BehaviourMainView, BehaviourMainModel> {

    public BehaviourMainPresenter(BehaviourMainView view, BehaviourMainModel model) {
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
