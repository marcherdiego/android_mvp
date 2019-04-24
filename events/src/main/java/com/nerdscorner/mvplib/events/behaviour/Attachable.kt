package com.nerdscorner.mvplib.events.behaviour

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/**
 * Public interface for attaching specific contexts
 */
interface Attachable {

    /**
     * Set this behaviour's execution context.
     *
     * @param activity the view where this behaviour is attached.
     */
    fun attach(activity: AppCompatActivity)

    /**
     * Set this behaviour's execution context.
     *
     * @param fragment the view where this behaviour is attached.
     */
    fun attach(fragment: Fragment)

}
