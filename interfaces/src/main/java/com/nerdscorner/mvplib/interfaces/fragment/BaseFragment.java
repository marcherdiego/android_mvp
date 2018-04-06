package com.nerdscorner.mvplib.interfaces.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.v4.app.Fragment;

import com.nerdscorner.mvplib.interfaces.presenter.BaseFragmentPresenter;

@Keep
public abstract class BaseFragment extends Fragment {

    protected BaseFragmentPresenter presenter;

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
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

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        presenter.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }
}
