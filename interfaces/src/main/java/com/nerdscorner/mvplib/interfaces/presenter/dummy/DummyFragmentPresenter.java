package com.nerdscorner.mvplib.interfaces.presenter.dummy;

import android.app.Fragment;
import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.interfaces.model.dummy.DummyModel;
import com.nerdscorner.mvplib.interfaces.presenter.BaseFragmentPresenter;
import com.nerdscorner.mvplib.interfaces.view.dummy.DummyFragmentView;

public class DummyFragmentPresenter extends BaseFragmentPresenter<DummyFragmentView, DummyModel> {
    public DummyFragmentPresenter(@NonNull Fragment fragment) {
        super(new DummyFragmentView(fragment), new DummyModel());
    }
}
