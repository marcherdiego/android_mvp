package com.nerdscorner.mvplib.events.model;

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel;
import com.nerdscorner.mvplib.events.bus.Bus;

public class BaseEventsModel extends BaseModel {

    private Bus bus;

    public BaseEventsModel() {
        bus = Bus.getDefaultEventBus();
    }

    public BaseEventsModel(Bus bus) {
        this.bus = bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public Bus getBus() {
        return bus;
    }
}
