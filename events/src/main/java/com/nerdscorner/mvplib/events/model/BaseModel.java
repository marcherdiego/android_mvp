package com.nerdscorner.mvplib.events.model;

import android.support.annotation.Keep;

import org.greenrobot.eventbus.EventBus;

@Keep
public class BaseModel {

    protected final EventBus bus;

    public BaseModel() {
        bus = EventBus.getDefault();
    }

    public EventBus getBus() {
        return bus;
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onStart() {
    }

    public void onStop() {
    }
}
