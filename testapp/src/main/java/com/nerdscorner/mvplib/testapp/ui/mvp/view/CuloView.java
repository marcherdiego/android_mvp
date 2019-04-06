package com.nerdscorner.mvplib.testapp.ui.mvp.view;

import com.nerdscorner.mvplib.events.view.BaseActivityView;
import com.nerdscorner.mvplib.events.activity.BaseActivity;

public class CuloView extends BaseActivityView {
    public CuloView(BaseActivity activity) {
        super(activity);
        bus.post(null);
    }
}
