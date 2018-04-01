package com.nerdscorner.mvplib.events.presenter;

import android.support.annotation.Keep;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuItem;

import com.nerdscorner.mvplib.events.model.BaseModel;
import com.nerdscorner.mvplib.events.view.BaseActivityView;

@Keep
public class BaseActivityPresenter<V extends BaseActivityView, M extends BaseModel> extends BasePresenter<V, M> {

    public BaseActivityPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return false;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        return false;
    }
}
