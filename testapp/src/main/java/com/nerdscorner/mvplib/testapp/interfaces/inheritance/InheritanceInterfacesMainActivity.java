package com.nerdscorner.mvplib.testapp.interfaces.inheritance;

import android.os.Bundle;

import com.nerdscorner.mvplib.interfaces.activity.BaseActivity;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.model.InheritanceMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.presenter.InheritanceMainPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.view.InheritanceMainView;

public class InheritanceInterfacesMainActivity extends BaseActivity<InheritanceMainPresenter> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new InheritanceMainPresenter(
                new InheritanceMainView(this),
                new InheritanceMainModel()
        );
    }
}
