package com.nerdscorner.interfacestestapp.mvp.presenter.implementations;


import com.nerdscorner.interfacestestapp.mvp.model.implementations.MainModel;
import com.nerdscorner.interfacestestapp.mvp.presenter.interfaces.MainPresenterInterface;
import com.nerdscorner.interfacestestapp.mvp.view.implementations.MainView;
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
