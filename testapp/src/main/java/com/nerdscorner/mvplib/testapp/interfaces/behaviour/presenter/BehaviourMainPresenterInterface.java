package com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter;

import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;

public interface BehaviourMainPresenterInterface extends Presenter {
    void onActionClicked();

    void onBackgroundTaskCompleted();
}
