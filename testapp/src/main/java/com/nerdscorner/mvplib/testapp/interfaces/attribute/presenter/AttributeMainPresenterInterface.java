package com.nerdscorner.mvplib.testapp.interfaces.attribute.presenter;

import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;

public interface AttributeMainPresenterInterface extends Presenter {

    void onActionClicked();

    void onBackgroundTaskCompleted();
}
