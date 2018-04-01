package com.nerdscorner.mvplib.events.view;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

@Keep
public abstract class BaseFragmentView extends BaseView {

    protected final EventBus bus;
    private WeakReference<Fragment> fragmentRef;

    public BaseFragmentView(@NonNull Fragment fragment) {
        fragmentRef = new WeakReference<>(fragment);
        bus = EventBus.getDefault();
    }

    @Nullable
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
