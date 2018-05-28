package com.nerdscorner.mvplib.interfaces.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.interfaces.model.BaseModel;
import com.nerdscorner.mvplib.interfaces.view.BaseActivityView;

public class BaseActivityPresenter<V extends BaseActivityView, M extends BaseModel> extends BasePresenter<V, M> {

    public BaseActivityPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }

    public boolean onBackPressed() {
        return false;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }

    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }

    public void onDestroy() {
        view.onDestroy();
        model.onDestroy();
    }
}
