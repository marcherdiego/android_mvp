package com.nerdscorner.mvplib.interfaces.view;

import com.nerdscorner.mvplib.commons.mvp.presenter.BasePresenter;
import com.nerdscorner.mvplib.commons.mvp.view.BaseView;

public abstract class BaseInterfacesView<P extends BasePresenter> extends BaseView {
    protected P presenter;

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }

}
