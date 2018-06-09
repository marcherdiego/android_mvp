package com.nerdscorner.mvplib.events.presenter.dummy;

import android.app.Fragment;
import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.events.model.dummy.DummyModel;
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter;
import com.nerdscorner.mvplib.events.view.dummy.DummyFragmentView;

public class DummyFragmentPresenter extends BaseFragmentPresenter<DummyFragmentView, DummyModel> {
    public DummyFragmentPresenter(@NonNull Fragment fragment) {
        super(new DummyFragmentView(fragment), new DummyModel());
    }
}
