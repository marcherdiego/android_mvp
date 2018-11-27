package com.nerdscorner.mvplib.interfaces.presenter;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.MenuItem;

import com.nerdscorner.mvplib.commons.mvp.presenter.Presenter;
import com.nerdscorner.mvplib.interfaces.model.BaseInterfacesModel;
import com.nerdscorner.mvplib.interfaces.model.InterfacesModelInterface;
import com.nerdscorner.mvplib.interfaces.view.BaseInterfacesView;
import com.nerdscorner.mvplib.interfaces.view.InterfacesViewInterface;

public abstract class BaseInterfacesPresenter<V extends InterfacesViewInterface, M extends InterfacesModelInterface> implements Presenter {
    protected V view;
    protected M model;

    BaseInterfacesPresenter(@NonNull V view, @NonNull M model) {
        this.view = view;
        this.model = model;
        if (!(view instanceof BaseInterfacesView)) {
            throw new IllegalArgumentException("Malformed MVP, your view must extend from BaseInterfacesView");
        }
        if (!(model instanceof BaseInterfacesModel)) {
            throw new IllegalArgumentException("Malformed MVP, your model must extend from BaseInterfacesModel");
        }
        ((BaseInterfacesView) view).setPresenter(this);
        ((BaseInterfacesModel) model).setPresenter(this);
    }

    @Override
    public void onStart() {
        view.onStart();
        model.onStart();
    }

    @Override
    public void onResume() {
        view.onResume();
        model.onResume();
    }

    @Override
    public void onPause() {
        view.onPause();
        model.onPause();
    }

    @Override
    public void onStop() {
        view.onStop();
        model.onStop();
    }

    @Override
    public void onDestroyView() {
        view.onDestroyView();
        view.unbind();
        model.onDestroyView();
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }
}
