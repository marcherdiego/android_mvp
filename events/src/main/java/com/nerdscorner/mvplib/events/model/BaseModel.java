package com.nerdscorner.mvplib.events.model;

import org.greenrobot.eventbus.EventBus;

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

    public void removeStickyEvent(Object event) {
        bus.removeStickyEvent(event);
    }
}