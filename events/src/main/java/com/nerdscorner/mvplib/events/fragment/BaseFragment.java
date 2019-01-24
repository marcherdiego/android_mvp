package com.nerdscorner.mvplib.events.fragment;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.nerdscorner.mvplib.events.config.MvpConfig;
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt;
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt;
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter;

public abstract class BaseFragment<P extends BaseFragmentPresenter> extends Fragment {

    protected P presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (MvpConfig.getRegisterAt() == RegisterAt.ON_CREATE) {
            presenter.getBus().register(presenter);
        }
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (MvpConfig.getRegisterAt() == RegisterAt.ON_START) {
            presenter.getBus().register(presenter);
        }
        presenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (MvpConfig.getRegisterAt() == RegisterAt.ON_RESUME) {
            presenter.getBus().register(presenter);
        }
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        if (MvpConfig.getUnregisterAt() == UnregisterAt.ON_PAUSE) {
            presenter.getBus().unregister(presenter);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        presenter.onStop();
        if (MvpConfig.getUnregisterAt() == UnregisterAt.ON_STOP) {
            presenter.getBus().unregister(presenter);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            presenter.onDestroyView();
            if (MvpConfig.getUnregisterAt() == UnregisterAt.ON_DESTROY) {
                presenter.getBus().unregister(presenter);
            }
        } catch (Exception ignored) {
        } finally {
            presenter = null;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        presenter.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return !presenter.onOptionsItemSelected(item) && super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        presenter.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (presenter != null) {
            presenter.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onViewStateRestored(savedInstanceState);
    }
}
