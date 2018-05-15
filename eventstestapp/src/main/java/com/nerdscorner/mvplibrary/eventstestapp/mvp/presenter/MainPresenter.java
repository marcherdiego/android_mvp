package com.nerdscorner.mvplibrary.eventstestapp.mvp.presenter;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplibrary.eventstestapp.mvp.model.MainModel;
import com.nerdscorner.mvplibrary.eventstestapp.mvp.model.MainModel.BackgroundTaskCompletedEvent;
import com.nerdscorner.mvplibrary.eventstestapp.mvp.view.MainView;
import com.nerdscorner.mvplibrary.eventstestapp.mvp.view.MainView.ActionClickedEvent;

import org.greenrobot.eventbus.Subscribe;

public class MainPresenter extends BaseActivityPresenter<MainView, MainModel> {

    public MainPresenter(MainView view, MainModel model) {
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
