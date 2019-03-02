package com.nerdscorner.mvplib.testapp.app

import android.app.Application

import com.nerdscorner.mvplib.events.config.MvpConfig
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        MvpConfig.initWith(RegisterAt.ON_START, UnregisterAt.ON_STOP)
    }
}
