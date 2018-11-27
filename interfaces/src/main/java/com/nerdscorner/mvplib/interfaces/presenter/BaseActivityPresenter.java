package com.nerdscorner.mvplib.interfaces.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.interfaces.model.InterfacesModelInterface;
import com.nerdscorner.mvplib.interfaces.view.InterfacesViewInterface;

public class BaseActivityPresenter<V extends InterfacesViewInterface, M extends InterfacesModelInterface> extends BaseInterfacesPresenter<V, M> {

    public BaseActivityPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }

    @Override
    public boolean onBackPressed() {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
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

    public void onDestroy() {
        view.onDestroy();
        model.onDestroy();
    }
}
