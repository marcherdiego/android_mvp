package com.nerdscorner.mvplib.events.model

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel
import com.nerdscorner.mvplib.events.bus.Bus

open class BaseEventsModel : BaseModel {

    var bus: Bus

    constructor() {
        bus = Bus.defaultBus
    }

    constructor(bus: Bus) {
        this.bus = bus
    }
}
