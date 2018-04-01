package com.nerdscorner.mvplib.interfaces.fragment;

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
}
