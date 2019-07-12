package com.nerdscorner.mvplib.events.bus

import android.os.Handler
import android.os.Looper
import android.util.Log
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class Bus private constructor(private val eventBus: EventBus) {

    /**
     * Register a subscriber to this bus
     *
     * @param subscriber the object to subscribe
     */
    fun register(subscriber: Any?) {
        if (subscriber == null) {
            Log.e(TAG, "Subscriber cannot be null.")
            return
        }
        try {
            if (!isRegistered(subscriber)) {
                eventBus.register(subscriber)
            }
        } catch (exception: Exception) {
            //No @Subscribe annotations detected
            Log.e(TAG, exception.message)
        }
    }

    /**
     * Unregister a previously subscribed object from this bus
     *
     * @param subscriber the object to unsubscribe
     */
    fun unregister(subscriber: Any?) {
        if (subscriber == null) {
            Log.e(TAG, "Subscriber cannot be null.")
            return
        }
        try {
            if (isRegistered(subscriber)) {
                eventBus.unregister(subscriber)
            }
        } catch (exception: Exception) {
            //No @Subscribe annotations detected
            Log.e(TAG, exception.message)
        }
    }

    /**
     * Checks if an object is registered to this Bus
     *
     * @param subscriber object to check
     * @return boolean if the object is already registered
     */
    fun isRegistered(subscriber: Any) = eventBus.isRegistered(subscriber)

    /**
     * Posts the given event to the event bus on the given thread.
     */
    @JvmOverloads
    fun post(event: Any, threadMode: ThreadMode = ThreadMode.POSTING) {
        when (threadMode) {
            ThreadMode.MAIN -> if (Looper.myLooper() == Looper.getMainLooper()) {
                eventBus.post(event)
            } else {
                Handler(Looper.getMainLooper()).post { eventBus.post(event) }
            }
            ThreadMode.POSTING -> eventBus.post(event)
            else -> Thread(Runnable { eventBus.post(event) }).start()
        }
    }

    /**
     * Posts the given event to the event bus and holds on to the event (because it is sticky). The most recent sticky
     * event of an event's type is kept in memory for future access by subscribers using [Subscribe.sticky].
     */
    fun postSticky(event: Any) {
        eventBus.postSticky(event)
    }

    /**
     * Gets the most recent sticky event for the given type.
     *
     * @see .postSticky
     */
    fun <T> getStickyEvent(eventType: Class<T>) = eventBus.getStickyEvent(eventType)

    /**
     * Remove and gets the recent sticky event for the given event type.
     *
     * @see .postSticky
     */
    fun <T> removeStickyEvent(eventType: Class<T>) = eventBus.removeStickyEvent(eventType)

    /**
     * Removes the sticky event if it equals to the given event.
     *
     * @return true if the events matched and the sticky event was removed.
     */
    fun removeStickyEvent(event: Any) = eventBus.removeStickyEvent(event)

    /**
     * Removes all sticky events.
     */
    fun removeAllStickyEvents() {
        eventBus.removeAllStickyEvents()
    }

    fun hasSubscriberForEvent(eventClass: Class<*>) = eventBus.hasSubscriberForEvent(eventClass)

    companion object {

        const val TAG = "Bus"

        val defaultBus: Bus
            get() = getDefaultEventBus()

        val newInstance: Bus
            get() = getNewEventBus()

        /**
         * Returns the default event bus
         */
        fun getDefaultEventBus() = Bus(EventBus.getDefault())

        /**
         * Returns a new instance of the event bus
         */
        fun getNewEventBus() = Bus(EventBus())

        /**
         * Register a subscriber to the default event bus
         *
         * @param subscriber the object to subscribe
         */
        fun registerDefault(subscriber: Any) {
            if (!isRegisteredDefault(subscriber)) {
                defaultBus.register(subscriber)
            }
        }

        /**
         * Unregister a previously subscribed object from the default event bus
         *
         * @param subscriber the object to unsubscribe
         */
        fun unregisterDefault(subscriber: Any) {
            defaultBus.unregister(subscriber)
        }

        /**
         * Checks if an object is registered to the default EventBus
         *
         * @param subscriber object to check
         * @return boolean if the object is already registered
         */
        fun isRegisteredDefault(subscriber: Any) = defaultBus.isRegistered(subscriber)
    }
}
