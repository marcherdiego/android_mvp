package com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter;

import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.Fragment2Model;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.Fragment2View;

import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.Subscribe;

public class Fragment2Presenter extends BaseFragmentPresenter<Fragment2View, Fragment2Model> {
    public Fragment2Presenter(@NonNull Fragment2View view, @NonNull Fragment2Model model) {
        super(view, model);
        view.setText("Fragment 2");
    }

    @Subscribe
    public void onNoSubscribers(NoSubscriberEvent event) {
    }
}
