package com.nerdscorner.mvplib.events.config;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt.ON_CREATE;
import static com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt.ON_RESUME;
import static com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt.ON_START;
import static com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt.ON_DESTROY;
import static com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt.ON_PAUSE;
import static com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt.ON_STOP;

public class MvpConfig {

    @RegisterAt
    private static int registerAt = ON_RESUME;

    @UnregisterAt
    private static int unregisterAt = ON_PAUSE;

    public static void initWith(@RegisterAt int registerAt, @UnregisterAt int unregisterAt) {
        MvpConfig.registerAt = registerAt;
        MvpConfig.unregisterAt = unregisterAt;
    }

    @RegisterAt
    public static int getRegisterAt() {
        return registerAt;
    }

    public static void setRegisterAt(@RegisterAt int registerAt) {
        MvpConfig.registerAt = registerAt;
    }

    @UnregisterAt
    public static int getUnregisterAt() {
        return unregisterAt;
    }

    public static void setUnregisterAt(@UnregisterAt int unregisterAt) {
        MvpConfig.unregisterAt = unregisterAt;
    }

    @IntDef({ON_CREATE, ON_START, ON_RESUME})
    @Retention(RetentionPolicy.SOURCE)
    public @interface RegisterAt {
        int ON_CREATE = 1;
        int ON_START = 2;
        int ON_RESUME = 3;
    }

    @IntDef({ON_DESTROY, ON_STOP, ON_PAUSE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface UnregisterAt {
        int ON_DESTROY = 1;
        int ON_STOP = 2;
        int ON_PAUSE = 3;
    }
}
