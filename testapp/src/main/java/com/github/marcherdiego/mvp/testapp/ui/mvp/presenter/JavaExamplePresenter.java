package com.github.marcherdiego.mvp.testapp.ui.mvp.presenter;

import com.github.marcherdiego.mvp.events.presenter.BaseActivityPresenter;
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.JavaExampleModel;
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.JavaExampleView;

public class JavaExamplePresenter extends BaseActivityPresenter<JavaExampleView, JavaExampleModel> {
    public JavaExamplePresenter(JavaExampleView view, JavaExampleModel model) {
        super(view, model);
    }
}
