package com.nerdscorner.mvplib.testapp.interfaces.inheritance.presenter;

import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;

public interface InheritanceMainPresenterInterface extends Presenter {
    void onActionClicked();

    void onBackgroundTaskCompleted();
}
