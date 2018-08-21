package com.nerdscorner.mvplib.events.view;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.nerdscorner.mvplib.commons.mvp.view.BaseView;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

public abstract class BaseFragmentView extends BaseView {

    private WeakReference<Fragment> fragmentRef;
    protected final EventBus bus;

    public BaseFragmentView(@NonNull Fragment fragment) {
        fragmentRef = new WeakReference<>(fragment);
        bus = EventBus.getDefault();
    }

    @Nullable
    @Override
    public Activity getActivity() {
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
