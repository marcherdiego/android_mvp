package com.nerdscorner.mvplib.testapp.events.attribute.fragments.model;

import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.model.BaseEventsModel;

public class AttributeFragmentMainModel extends BaseEventsModel {
    public static final int FRAGMENT_1 = 1;
    public static final int FRAGMENT_2 = 2;

    private int currentFragment = FRAGMENT_2;

    public AttributeFragmentMainModel(Bus bus) {
        super(bus);
    }

    public int getNextFragment() {
        switch (currentFragment) {
            case FRAGMENT_1:
                currentFragment = FRAGMENT_2;
                break;
            case FRAGMENT_2:
                currentFragment = FRAGMENT_1;
        }
        return currentFragment;
    }
}
