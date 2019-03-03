package com.nerdscorner.mvplib.commons.behaviour

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

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
