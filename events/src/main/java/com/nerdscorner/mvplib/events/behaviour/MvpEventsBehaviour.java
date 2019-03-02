package com.nerdscorner.mvplib.events.behaviour;

import org.greenrobot.eventbus.EventBus;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Parcel;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.MenuItem;
import com.nerdscorner.mvplib.commons.behaviour.Behaviour;
import com.nerdscorner.mvplib.commons.mvp.presenter.BasePresenter;

public class MvpEventsBehaviour extends Behaviour {

    private final static int CONTENTS_DEFAULT = 0;

    protected BasePresenter presenter;

    public final static Creator<MvpEventsBehaviour> CREATOR = new Creator<MvpEventsBehaviour>() {
        @Override
        public MvpEventsBehaviour createFromParcel(final Parcel in) {
            return new MvpEventsBehaviour(in);
        }

        @Override
        public MvpEventsBehaviour[] newArray(final int size) {
            return new MvpEventsBehaviour[size];
        }
    };

    public MvpEventsBehaviour(BasePresenter presenter) {
        this.presenter = presenter;
    }

    /**
     * Default scope because it's used from {@link #CREATOR}.
     *
     * @param in The parcel with this type values.
     */
    /* default */ MvpEventsBehaviour(final Parcel in) {
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
        try {
            EventBus.getDefault().register(presenter);
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
        try {
            EventBus.getDefault().unregister(presenter);
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
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

    @SuppressWarnings("unchecked")
    @Nullable
    @Override
    public <Component> Component getComponent(@NonNull Class<Component> componentClass) {
        if (componentClass.isAssignableFrom(EventBus.class)) {
            return (Component) EventBus.getDefault();
        }
        return null;
    }
}
