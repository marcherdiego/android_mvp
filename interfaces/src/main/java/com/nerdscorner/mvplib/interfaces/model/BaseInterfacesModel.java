package com.nerdscorner.mvplib.interfaces.model;

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel;
import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;

public class BaseInterfacesModel<P extends Presenter> extends BaseModel {

    protected P presenter;

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void onDestroy() {
    }

    public void onDestroyView() {
    }
}
