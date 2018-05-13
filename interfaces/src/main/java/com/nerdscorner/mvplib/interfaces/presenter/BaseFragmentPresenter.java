package com.nerdscorner.mvplib.interfaces.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;

import com.nerdscorner.mvplib.interfaces.model.BaseModel;
import com.nerdscorner.mvplib.interfaces.view.BaseFragmentView;

public class BaseFragmentPresenter<V extends BaseFragmentView, M extends BaseModel> extends BasePresenter<V, M> {

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
    }
}
