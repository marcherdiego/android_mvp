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
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.Fragment2Model;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter.Fragment2Presenter;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.Fragment2View;

import butterknife.ButterKnife;

public class Fragment2 extends Fragment {

    private Fragment2Presenter presenter;
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

        bus = Bus.getNewEventBus();
        presenter = new Fragment2Presenter(
                new Fragment2View(this, bus),
                new Fragment2Model(bus)
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
