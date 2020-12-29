package com.nerdscorner.mvplib.testapp.events.ui.mvp.presenter;

import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter;

import com.nerdscorner.mvplib.testapp.events.ui.mvp.view.JavaExampleView;
import com.nerdscorner.mvplib.testapp.events.ui.mvp.model.JavaExampleModel;

public class JavaExamplePresenter extends BaseActivityPresenter<JavaExampleView, JavaExampleModel> {
    public JavaExamplePresenter(JavaExampleView view, JavaExampleModel model) {
        super(view, model);
    }
}
