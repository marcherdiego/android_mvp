package com.nerdscorner.mvplib.testapp.events.attribute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.events.attribute.model.AttributeMainModel;
import com.nerdscorner.mvplib.testapp.events.attribute.presenter.AttributeMainPresenter;
import com.nerdscorner.mvplib.testapp.events.attribute.view.AttributeMainView;

public class AttributeEventsMainActivity extends AppCompatActivity {

    private AttributeMainPresenter presenter;
    private Bus bus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bus = Bus.getNewEventBus();
        presenter = new AttributeMainPresenter(
                new AttributeMainView(this, bus),
                new AttributeMainModel(bus)
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
}
