package com.nerdscorner.mvplib.interfaces.presenter;

import android.os.Bundle;
import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.interfaces.model.BaseModel;
import com.nerdscorner.mvplib.interfaces.view.BaseActivityView;

@Keep
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

    public void onRestoreInstanceState(Bundle savedInstanceState) {
    }
}
