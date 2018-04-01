package com.nerdscorner.mvplib.events.fragment;

import android.support.annotation.Keep;
import android.support.v4.app.Fragment;

import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter;

import org.greenrobot.eventbus.EventBus;

@Keep
public abstract class BaseFragment extends Fragment {

    protected BaseFragmentPresenter presenter;

    @Override
    public void onResume() {
        super.onResume();
        try {
            presenter.onResume();
            EventBus.getDefault().register(presenter);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            presenter.onPause();
            EventBus.getDefault().unregister(presenter);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            presenter.onDestroyView();
        } catch (Exception ignored) {
        } finally {
            presenter = null;
        }
    }
}
