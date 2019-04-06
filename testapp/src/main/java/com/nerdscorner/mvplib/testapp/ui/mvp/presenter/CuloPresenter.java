package com.nerdscorner.mvplib.testapp.ui.mvp.presenter;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

import com.nerdscorner.mvplib.testapp.ui.mvp.model.CuloModel;
import com.nerdscorner.mvplib.testapp.ui.mvp.view.CuloView;

public class CuloPresenter extends BaseActivityPresenter<CuloView, CuloModel> {
    public CuloPresenter(CuloView view, CuloModel model) {
        super(view, model);
    }
}
