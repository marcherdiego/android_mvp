package com.nerdscorner.mvplib.interfaces.presenter.dummy;

import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.interfaces.activity.BaseActivity;
import com.nerdscorner.mvplib.interfaces.model.dummy.DummyModel;
import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.interfaces.view.dummy.DummyActivityView;

public class DummyActivityPresenter extends BaseActivityPresenter<DummyActivityView, DummyModel> {
    public DummyActivityPresenter(@NonNull BaseActivity baseActivity) {
        super(new DummyActivityView(baseActivity), new DummyModel());
    }
}
