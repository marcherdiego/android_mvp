package com.nerdscorner.mvplibrary.mvp.presenter;

import com.nerdscorner.mvplib.presenter.BaseActivityPresenter;
import com.nerdscorner.mvplibrary.mvp.model.MainModel;
import com.nerdscorner.mvplibrary.mvp.view.MainView;
import com.nerdscorner.mvplibrary.mvp.view.MainView.ActionClickedEvent;

import org.greenrobot.eventbus.Subscribe;

public class MainPresenter extends BaseActivityPresenter<MainView, MainModel> {

    public MainPresenter(MainView view, MainModel model) {
        super(view, model);
    }

    @Subscribe
    public void onActionClicked(ActionClickedEvent event) {
        view.setTextValue("Culooooooooooo");
    }
}
