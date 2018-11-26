package com.nerdscorner.mvplib.interfaces.behaviour;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.nerdscorner.mvplib.commons.behaviour.Behaviour;
import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;

public class MvpInterfacesBehaviour extends Behaviour {

    private final static int CONTENTS_DEFAULT = 0;

    protected Presenter presenter;

    public final static Creator<MvpInterfacesBehaviour> CREATOR = new Creator<MvpInterfacesBehaviour>() {
        @Override
        public MvpInterfacesBehaviour createFromParcel(final Parcel in) {
            return new MvpInterfacesBehaviour(in);
        }

        @Override
        public MvpInterfacesBehaviour[] newArray(final int size) {
            return new MvpInterfacesBehaviour[size];
        }
    };

    public MvpInterfacesBehaviour(Presenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Default scope because it's used from {@link #CREATOR}.
     *
     * @param in The parcel with this type values.
     */
    /* default */ MvpInterfacesBehaviour(final Parcel in) {
        super(in);
    }

    @Override
    public int describeContents() {
        return CONTENTS_DEFAULT;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter.onStart();
    }

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
    public void onStop() {
        super.onStop();
        presenter.onStop();
    }

    @Override
    public boolean onBackPressed() {
        return !presenter.onBackPressed() && super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return !presenter.onOptionsItemSelected(item) && super.onOptionsItemSelected(item);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        presenter.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        presenter.onConfigurationChanged(newConfig);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        presenter.onRestoreInstanceState(savedInstanceState);
    }
}
