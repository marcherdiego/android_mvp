package com.github.marcherdiego.mvp.testapp.ui.activities;

import android.os.Bundle;
import androidx.annotation.Nullable;
import com.github.marcherdiego.mvp.events.activity.BaseActivity;
import com.github.marcherdiego.mvp.testapp.R;
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.JavaExampleModel;
import com.github.marcherdiego.mvp.testapp.ui.mvp.presenter.JavaExamplePresenter;
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.JavaExampleView;

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
