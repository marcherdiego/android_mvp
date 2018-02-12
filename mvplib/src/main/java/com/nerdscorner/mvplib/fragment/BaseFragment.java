package com.nerdscorner.mvplib.fragment;

import android.support.annotation.Keep;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;

import com.nerdscorner.mvplib.bus.EventBusWrapper;
import com.nerdscorner.mvplib.presenter.BaseFragmentPresenter;

@Keep
public abstract class BaseFragment extends Fragment {

    protected BaseFragmentPresenter presenter;

    @StringRes
    public abstract int getTitle();

    @Override
    public void onResume() {
        super.onResume();
        try {
            presenter.onResume();
            EventBusWrapper.getDefault().register(presenter);
        } catch (Exception ignored) {
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        try {
            presenter.onPause();
            EventBusWrapper.getDefault().unregister(presenter);
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
