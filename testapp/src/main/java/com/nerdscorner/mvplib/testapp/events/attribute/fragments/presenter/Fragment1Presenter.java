package com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter;

import android.support.annotation.NonNull;

import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.Fragment1Model;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.Fragment1View;

import org.greenrobot.eventbus.NoSubscriberEvent;
import org.greenrobot.eventbus.Subscribe;

public class Fragment1Presenter extends BaseFragmentPresenter<Fragment1View, Fragment1Model> {
    public Fragment1Presenter(@NonNull Fragment1View view, @NonNull Fragment1Model model) {
        super(view, model);
        view.setText("Fragment 1");
    }

    @Subscribe
    public void onNoSubscribers(NoSubscriberEvent event) {
    }
}
