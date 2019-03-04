package com.nerdscorner.mvplib.testapp.events.attribute.fragments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.model.AttributeFragmentMainModel;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.presenter.AttributeForFragmentMainPresenter;
import com.nerdscorner.mvplib.testapp.events.attribute.fragments.view.AttributeFragmentMainView;

public class AttributeEventsForFragmentsMainActivity extends AppCompatActivity {

    private AttributeForFragmentMainPresenter presenter;
    private Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp_for_fragments);

        bus = Bus.Companion.getNewEventBus();
        presenter = new AttributeForFragmentMainPresenter(
                new AttributeFragmentMainView(this, bus),
                new AttributeFragmentMainModel(bus),
                bus
        );
    }

    @Override
    protected void onResume() {
        super.onResume();
        bus.register(presenter);
    }

    @Override
    protected void onPause() {
        bus.unregister(presenter);
        super.onPause();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //Do something here
        presenter.onBackPressed();
    }
}
