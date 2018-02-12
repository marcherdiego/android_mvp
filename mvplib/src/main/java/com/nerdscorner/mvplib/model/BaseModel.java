package com.nerdscorner.mvplib.model;

import android.support.annotation.Keep;

import com.nerdscorner.mvplib.bus.EventBusWrapper;

@Keep
public class BaseModel {

    protected final EventBusWrapper bus;

    public BaseModel() {
        bus = EventBusWrapper.getDefault();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
