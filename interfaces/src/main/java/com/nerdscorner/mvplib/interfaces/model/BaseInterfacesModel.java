package com.nerdscorner.mvplib.interfaces.model;

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel;
import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;

public class BaseInterfacesModel<P extends Presenter> extends BaseModel implements InterfacesModelInterface {

    protected P presenter;

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    public P getPresenter() {
        return presenter;
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onStart() {
    }

    @Override
    public void onStop() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void onDestroyView() {
    }
}
