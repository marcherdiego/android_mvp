package com.nerdscorner.mvplib.testapp.events.attribute.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.Fragment1Model;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter.Fragment1Presenter;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.Fragment1View;

import butterknife.ButterKnife;

public class Fragment1 extends Fragment {

    private Fragment1Presenter presenter;
    private Bus bus;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_example, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        bus = Bus.Companion.getNewEventBus();
        presenter = new Fragment1Presenter(
                new Fragment1View(this, bus),
                new Fragment1Model(bus)
        );
    }

    @Override
    public void onResume() {
        super.onResume();
        bus.register(presenter);
    }

    @Override
    public void onPause() {
        bus.unregister(presenter);
        super.onPause();
    }
}
