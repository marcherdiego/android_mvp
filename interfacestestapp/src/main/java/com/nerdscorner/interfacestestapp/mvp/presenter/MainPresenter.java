package com.nerdscorner.interfacestestapp.mvp.presenter;


import com.nerdscorner.interfacestestapp.mvp.model.MainModel;
import com.nerdscorner.interfacestestapp.mvp.view.MainView;
import com.nerdscorner.mvplib.interfaces.presenter.BaseActivityPresenter;

public class MainPresenter extends BaseActivityPresenter<MainView, MainModel> implements MainPresenterInterface {

    public MainPresenter(MainView view, MainModel model) {
        super(view, model);
    }

    @Override
    public void onActionClicked() {
        model.doSomethingInBackground();
    }

    @Override
    public void onBackgroundTaskCompleted() {
        view.setTextValue("Culooooooooooo");
    }
}
