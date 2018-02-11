package com.nerdscorner.mvplib.bus;

import android.support.annotation.Keep;

import org.greenrobot.eventbus.EventBus;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Keep
public class EventBusWrapper extends EventBus {

    private static volatile EventBusWrapper defaultInstance;

    public static EventBusWrapper getDefault() {
        if (defaultInstance == null) {
            synchronized (EventBusWrapper.class) {
                if (defaultInstance == null) {
                    defaultInstance = new EventBusWrapper();
                }
            }
        }
        return defaultInstance;
    }

    @Override
    public void post(Object event) {
        super.post(event);
    }

    public void post(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getConstructor();
            Object eventInstance = constructor.newInstance();
            post(eventInstance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void post(Class<?> clazz, Object... args) {
        try {
            Class<?>[] paramsClasses = new Class[args.length];
            Object[] initArgs = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                Object arg = args[i];
                paramsClasses[i] = arg.getClass();
                initArgs[i] = arg;
            }
            Constructor<?> constructor = clazz.getConstructor(paramsClasses);
            Object eventInstance = constructor.newInstance(initArgs);
            post(eventInstance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void postSticky(Object event) {
        super.postSticky(event);
    }

    public void postSticky(Class<?> clazz) {
        try {
            Constructor<?> constructor = clazz.getConstructor();
            Object eventInstance = constructor.newInstance();
            postSticky(eventInstance);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean removeStickyEvent(Object event) {
        return super.removeStickyEvent(event);
    }

    @Override
    public <T> T removeStickyEvent(Class<T> eventType) {
        return super.removeStickyEvent(eventType);
    }
}
