package com.nerdscorner.mvplib.events.presenter.dummy;

import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplib.events.model.dummy.DummyModel;
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplib.events.view.dummy.DummyActivityView;

public class DummyActivityPresenter extends BaseActivityPresenter<DummyActivityView, DummyModel> {
    public DummyActivityPresenter(@NonNull BaseActivity baseActivity) {
        super(new DummyActivityView(baseActivity), new DummyModel());
    }
}
