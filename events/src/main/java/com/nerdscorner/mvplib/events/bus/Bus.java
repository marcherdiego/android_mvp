package com.nerdscorner.mvplib.events.bus;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class Bus {

    private EventBus eventBus;

    private Bus(EventBus eventBus) {
        this.eventBus = eventBus;
    }

    @NonNull
    public static Bus getDefaultEventBus() {
        return new Bus(EventBus.getDefault());
    }

    @NonNull
    public static Bus getNewEventBus() {
        return new Bus(new EventBus());
    }

    /**
     * Register a subscriber to the default event bus
     *
     * @param subscriber the object to subscribe
     */
    public static void registerDefault(@NonNull final Object subscriber) {
        if (!isRegisteredDefault(subscriber)) {
            getDefaultEventBus().register(subscriber);
        }
    }

    /**
     * Unregister a previously subscribed object from the default event bus
     *
     * @param subscriber the object to unsubscribe
     */
    public static void unregisterDefault(@NonNull final Object subscriber) {
        getDefaultEventBus().unregister(subscriber);
    }

    /**
     * Checks if an object is registered to the default EventBus
     *
     * @param subscriber object to check
     * @return boolean if the object is already registered
     */
    public static boolean isRegisteredDefault(@NonNull final Object subscriber) {
        return getDefaultEventBus().isRegistered(subscriber);
    }


    /**
     * Register a subscriber to this bus
     *
     * @param subscriber the object to subscribe
     */
    public void register(@Nullable final Object subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber cannot be null.");
        }
        try {
            if (!isRegistered(subscriber)) {
                eventBus.register(subscriber);
            }
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
    }

    /**
     * Unregister a previously subscribed object from this bus
     *
     * @param subscriber the object to unsubscribe
     */
    public void unregister(@Nullable final Object subscriber) {
        if (subscriber == null) {
            throw new IllegalArgumentException("Subscriber cannot be null.");
        }
        try {
            if (isRegistered(subscriber)) {
                eventBus.unregister(subscriber);
            }
        } catch (Exception ignored) {
            //No @Subscribe annotations detected
        }
    }

    /**
     * Checks if an object is registered to this Bus
     *
     * @param subscriber object to check
     * @return boolean if the object is already registered
     */
    public boolean isRegistered(@NonNull final Object subscriber) {
        return eventBus.isRegistered(subscriber);
    }

    /**
     * Posts the given event to the event bus.
     */
    public void post(Object event) {
        eventBus.post(event);
    }

    /**
     * Posts the given event to the event bus and holds on to the event (because it is sticky). The most recent sticky
     * event of an event's type is kept in memory for future access by subscribers using {@link Subscribe#sticky()}.
     */
    public void postSticky(Object event) {
        eventBus.postSticky(event);
    }

    /**
     * Gets the most recent sticky event for the given type.
     *
     * @see #postSticky(Object)
     */
    public <T> T getStickyEvent(Class<T> eventType) {
        return eventBus.getStickyEvent(eventType);
    }

    /**
     * Remove and gets the recent sticky event for the given event type.
     *
     * @see #postSticky(Object)
     */
    public <T> T removeStickyEvent(Class<T> eventType) {
        return eventBus.removeStickyEvent(eventType);
    }

    /**
     * Removes the sticky event if it equals to the given event.
     *
     * @return true if the events matched and the sticky event was removed.
     */
    public boolean removeStickyEvent(Object event) {
        return eventBus.removeStickyEvent(event);
    }

    /**
     * Removes all sticky events.
     */
    public void removeAllStickyEvents() {
        eventBus.removeAllStickyEvents();
    }

    public boolean hasSubscriberForEvent(Class<?> eventClass) {
        return eventBus.hasSubscriberForEvent(eventClass);
    }
}
