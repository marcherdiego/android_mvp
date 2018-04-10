package com.nerdscorner.mvplib.events.view;


import org.greenrobot.eventbus.EventBus;

public class BaseView {
    protected final EventBus bus;

    public BaseView() {
        bus = EventBus.getDefault();
    }

    public void unbind() {
    }

    public void onResume() {
    }

    public void onPause() {
    }

    public void onDestroyView() {
    }

    public void onStop() {
    }

    public void onStart() {
    }
}
