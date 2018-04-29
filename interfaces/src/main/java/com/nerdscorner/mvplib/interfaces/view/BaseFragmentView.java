package com.nerdscorner.mvplib.interfaces.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.nerdscorner.mvplib.interfaces.presenter.BaseFragmentPresenter;

import java.lang.ref.WeakReference;

public abstract class BaseFragmentView<P extends BaseFragmentPresenter> extends BaseView {

    private WeakReference<Fragment> fragmentRef;

    public BaseFragmentView(@NonNull Fragment fragment) {
        fragmentRef = new WeakReference<>(fragment);
    }

    public void setPresenter(P presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public FragmentActivity getActivity() {
        Fragment fragment = fragmentRef.get();
        return (fragment == null) ? null : fragment.getActivity();
    }

    @Nullable
    public Context getContext() {
        return getActivity();
    }

    @Nullable
    public Fragment getFragment() {
        return fragmentRef.get();
    }
}
