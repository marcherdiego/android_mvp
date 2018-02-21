package com.nerdscorner.mvplib.model;

import android.support.annotation.Keep;

import org.greenrobot.eventbus.EventBus;

@Keep
public class BaseModel {

    protected final EventBus bus;

    public BaseModel() {
        bus = EventBus.getDefault();
    }

    public void onResume() {
    }

    public void onPause() {
    }
}
