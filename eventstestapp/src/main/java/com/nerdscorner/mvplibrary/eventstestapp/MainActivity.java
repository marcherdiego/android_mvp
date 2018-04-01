package com.nerdscorner.mvplibrary.eventstestapp;

import android.os.Bundle;

import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplibrary.R;
import com.nerdscorner.mvplibrary.eventstestapp.mvp.model.MainModel;
import com.nerdscorner.mvplibrary.eventstestapp.mvp.presenter.MainPresenter;
import com.nerdscorner.mvplibrary.eventstestapp.mvp.view.MainView;

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
