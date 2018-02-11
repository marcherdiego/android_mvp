package com.nerdscorner.mvplib.fragment;

import android.support.annotation.Keep;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.nerdscorner.mvplib.bus.EventBusWrapper;
import com.nerdscorner.mvplib.presenter.BaseFragmentPresenter;

@Keep
public abstract class BaseFragment extends Fragment {

    protected EventBusWrapper bus;
    protected BaseFragmentPresenter presenter;

    public BaseFragment(EventBusWrapper bus) {
        this.bus = bus;
    }

    @StringRes
    public abstract int getTitle();

    @Override
    public void onResume() {
        super.onResume();
        try {
            presenter.onResume();
            bus.register(presenter);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            presenter.onPause();
            bus.unregister(presenter);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            presenter.onDestroyView();
            presenter.unbind();
        } catch (Exception ignored) {
        } finally {
            presenter = null;
        }
    }
}
