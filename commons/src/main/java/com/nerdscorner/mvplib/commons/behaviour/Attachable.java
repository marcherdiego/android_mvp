package com.nerdscorner.mvplib.commons.behaviour;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Public interface for attaching specific contexts
 */
public interface Attachable {

    /**
     * Set this behaviour's execution context.
     *
     * @param activity the view where this behaviour is attached.
     */
    void attach(@NonNull final AppCompatActivity activity);

    /**
     * Set this behaviour's execution context.
     *
     * @param fragment the view where this behaviour is attached.
     */
    void attach(@NonNull final Fragment fragment);

}
