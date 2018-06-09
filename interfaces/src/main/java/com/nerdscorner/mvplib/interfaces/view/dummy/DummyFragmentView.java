package com.nerdscorner.mvplib.interfaces.view.dummy;

import android.app.Fragment;
import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.interfaces.view.BaseFragmentView;

public class DummyFragmentView extends BaseFragmentView {
    public DummyFragmentView(@NonNull Fragment fragment) {
        super(fragment);
    }
}
