package com.nerdscorner.mvplib.testapp.ui.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.nerdscorner.mvplib.events.activity.BaseActivity;

import com.nerdscorner.mvplib.testapp.ui.mvp.model.CuloModel;
import com.nerdscorner.mvplib.testapp.ui.mvp.presenter.CuloPresenter;
import com.nerdscorner.mvplib.testapp.ui.mvp.view.CuloView;

public class CuloActivity extends BaseActivity<CuloPresenter> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.<<YOUR_LAYOUT_HERE>>);

        presenter = new CuloPresenter(
                new CuloView(this),
                new CuloModel()
        );
    }
}
