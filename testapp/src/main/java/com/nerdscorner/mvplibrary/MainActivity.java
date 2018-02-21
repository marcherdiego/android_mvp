package com.nerdscorner.mvplibrary;

import android.os.Bundle;

import com.nerdscorner.mvplib.activity.BaseActivity;
import com.nerdscorner.mvplibrary.mvp.model.MainModel;
import com.nerdscorner.mvplibrary.mvp.presenter.MainPresenter;
import com.nerdscorner.mvplibrary.mvp.view.MainView;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(
                new MainView(this),
                new MainModel()
        );
    }
}
