package com.nerdscorner.mvplib.view;

import android.content.Context;
import android.support.annotation.Keep;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.nerdscorner.mvplib.bus.EventBusWrapper;

import java.lang.ref.WeakReference;

@Keep
public abstract class BaseFragmentView {

    protected final EventBusWrapper bus;
    private WeakReference<Fragment> fragmentRef;

    public BaseFragmentView(Fragment fragment, EventBusWrapper bus) {
        fragmentRef = new WeakReference<>(fragment);
        this.bus = bus;
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

    public void unbind() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroyView() {
    }
}
