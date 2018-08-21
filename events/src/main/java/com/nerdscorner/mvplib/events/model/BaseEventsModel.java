package com.nerdscorner.mvplib.events.model;

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel;

import org.greenrobot.eventbus.EventBus;

public class BaseEventsModel extends BaseModel {

    protected final EventBus bus;

    public BaseEventsModel() {
        bus = EventBus.getDefault();
    }

    public EventBus getBus() {
        return bus;
    }
}
