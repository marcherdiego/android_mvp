package com.nerdscorner.mvplib.interfaces.presenter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;

import com.nerdscorner.mvplib.interfaces.model.BaseInterfacesModel;
import com.nerdscorner.mvplib.interfaces.view.BaseInterfacesView;

public class BaseFragmentPresenter<V extends BaseInterfacesView, M extends BaseInterfacesModel> extends BaseInterfacesPresenter<V, M> {

    public BaseFragmentPresenter(@NonNull V view, @NonNull M model) {
        super(view, model);
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    }

    public void onViewStateRestored(Bundle savedInstanceState) {
    }
}
