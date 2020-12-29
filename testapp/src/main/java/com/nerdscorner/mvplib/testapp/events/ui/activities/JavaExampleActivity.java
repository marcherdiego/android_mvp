package com.nerdscorner.mvplib.testapp.events.ui.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.JavaExampleModel;
import com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter.JavaExamplePresenter;
import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.JavaExampleView;

public class JavaExampleActivity extends BaseActivity<JavaExamplePresenter> {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.java_example_activity);

        presenter = new JavaExamplePresenter(
                new JavaExampleView(this),
                new JavaExampleModel()
        );
    }
}
