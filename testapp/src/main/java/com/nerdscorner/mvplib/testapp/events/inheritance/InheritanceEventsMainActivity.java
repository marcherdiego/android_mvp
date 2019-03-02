package com.nerdscorner.mvplib.testapp.events.inheritance;

import android.os.Bundle;

import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.inheritance.model.InheritanceMainModel;
import com.nerdscorner.mvplib.testapp.events.inheritance.presenter.InheritanceMainPresenter;
import com.nerdscorner.mvplib.testapp.events.inheritance.view.InheritanceMainView;

public class InheritanceEventsMainActivity extends BaseActivity<InheritanceMainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        setPresenter(new InheritanceMainPresenter(
                new InheritanceMainView(this),
                new InheritanceMainModel()
        ));
    }
}
