package com.nerdscorner.mvplib.commons.behaviour;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;

/**
 * Abstract class denoting a behaviour.
 *
 * A behaviour will be called for each {@link ComponentsCallback} method, and might be also called
 * by the user to attach particular arguments / parameters.
 *
 * A behaviour shouldn't contain mandatory fields or params required by external elements, it might
 * contain optional arguments, but it should be able to work well isolated.
 */
@SuppressWarnings("PMD.EmptyMethodInAbstractClassShouldBeAbstract")
public abstract class Behaviour implements Parcelable, ComponentsCallback, Attachable {

    @Nullable
    private WeakReference<Fragment> weakFragment;
    @Nullable
    private WeakReference<AppCompatActivity> weakActivity;

    /**
     * Default public constructor, used via reflection hence inheritances <b>should</b> have
     * a default empty constructor too.
     */
    public Behaviour() {
        // Do nothing.
    }

    /**
     * Parcelable constructor used when coming from a saved state.
     * @param in The parcel with this type values.
     */
    @SuppressWarnings("unused")
    public Behaviour(@NonNull final Parcel in) {
        // Do nothing.
    }

    /**
     * @return <code>null</code> if the execution context is a fragment not attached to an {@link AppCompatActivity}. <code>null</code> if the weak reference to the activity is erased. Otherwise, the activity which this behaviour was attached.
     */
    @Nullable
    @CheckResult
    protected final AppCompatActivity getActivity() {
        Context context = getContext();

        if (context instanceof AppCompatActivity) {
            return (AppCompatActivity) context;
        }
        return null;
    }

    /**
     * <strong>Important: This is for fragments only</strong>
     *
     * @return <code>null</code> if the execution context is an activity. <code>null</code> if the weak reference to the fragment is erased. Otherwise, the fragment which this behaviour was attached.
     */
    @Nullable
    @CheckResult
    protected final Fragment getFragment() {
        return weakFragment == null ? null : weakFragment.get();
    }

    /**
     * @return <code>null</code> only when this feature's host has been removed by the garbage collector.
     */
    @Nullable
    @CheckResult
    protected final Context getContext() {
        if (weakActivity != null) {
            final AppCompatActivity activity = weakActivity.get();
            if (activity != null) {
                return activity;
            }
        }

        if (weakFragment != null) {
            final Fragment fragment = weakFragment.get();
            if (fragment != null) {
                return fragment.getContext();
            }
        }

        return null;
    }

    /**
     * Set this behaviour's execution context.
     *
     * @param activity the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public final void attach(@NonNull final AppCompatActivity activity) {
        this.weakActivity = new WeakReference<>(activity);
    }

    /**
     * Set this behaviour's execution context.
     *
     * @param fragment the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public final void attach(@NonNull final Fragment fragment) {
        this.weakFragment = new WeakReference<>(fragment);
    }

    /**
     * @inheritDoc
     */
    @CheckResult
    @NonNull
    @Override
    public View setContentView(@NonNull final View view, @Nullable final ViewGroup.LayoutParams params) {
        return view;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onDestroy() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onStart() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onStop() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onResume() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onPause() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean onPrepareOptionsMenu(@NonNull Menu menu) {
        return true;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onAttach(@Nullable Context context) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onDetach() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Override
    public boolean onBackPressed() {
        return false;
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        // Do nothing
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    @Nullable
    @Override
    public <Component> Component getComponent(@NonNull Class<Component> componentClass) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @NonNull
    @Override
    public Context attachBaseContext(@NonNull final Context context) {
        return context;
    }

    /**
     * Equals is final, we explicitly want this and only this implementation
     *
     * As behaviours must be unique, its a class comparison
     *
     * @param obj to compare to
     * @return true if same, false otherwise
     */
    @Override
    public final boolean equals(Object obj) {
        return obj.getClass().equals(getClass());
    }

    /**
     * We will use as a hash the string of the name, we dont want different instances of this class
     * living together. So we identify all classes as one
     * @return int with the hash, unique per class
     */
    @Override
    public final int hashCode() {
        return this.getClass().getName().hashCode();
    }

}