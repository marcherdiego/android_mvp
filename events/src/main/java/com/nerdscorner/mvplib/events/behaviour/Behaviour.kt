package com.nerdscorner.mvplib.events.behaviour

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.Parcelable
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CheckResult
import androidx.annotation.RestrictTo
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.lang.ref.WeakReference

/**
 * Abstract class denoting a behaviour.
 *
 * A behaviour will be called for each [ComponentsCallback] method, and might be also called
 * by the user to attach particular arguments / parameters.
 *
 * A behaviour shouldn't contain mandatory fields or params required by external elements, it might
 * contain optional arguments, but it should be able to work well isolated.
 */
@Parcelize
open class Behaviour : ComponentsCallback, Attachable, Parcelable {

    @IgnoredOnParcel
    private var weakFragment: WeakReference<Fragment>? = null
    @IgnoredOnParcel
    private var weakActivity: WeakReference<AppCompatActivity>? = null

    /**
     * @return `null` if the execution context is a fragment not attached to an [AppCompatActivity]. `null` if the weak reference to the activity is erased. Otherwise, the activity which this behaviour was attached.
     */
    protected val activity: AppCompatActivity?
        @CheckResult
        get() {
            val context = context

            return if (context is AppCompatActivity) {
                context
            } else null
        }

    /**
     * **Important: This is for fragments only**
     *
     * @return `null` if the execution context is an activity. `null` if the weak reference to the fragment is erased. Otherwise, the fragment which this behaviour was attached.
     */
    protected val fragment: Fragment?
        @CheckResult
        get() = if (weakFragment == null) null else weakFragment?.get()

    /**
     * @return `null` only when this feature's host has been removed by the garbage collector.
     */
    protected val context: Context?
        @CheckResult
        get() {
            if (weakActivity != null) {
                val activity = weakActivity?.get()
                if (activity != null) {
                    return activity
                }
            }

            if (weakFragment != null) {
                val fragment = weakFragment?.get()
                if (fragment != null) {
                    return fragment.context
                }
            }

            return null
        }

    /**
     * Set this behaviour's execution context.
     *
     * @param activity the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun attach(activity: AppCompatActivity) {
        this.weakActivity = WeakReference(activity)
    }

    /**
     * Set this behaviour's execution context.
     *
     * @param fragment the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    override fun attach(fragment: Fragment) {
        this.weakFragment = WeakReference(fragment)
    }

    /**
     * @inheritDoc
     */
    @CheckResult
    override fun setContentView(view: View, params: ViewGroup.LayoutParams?): View {
        return view
    }

    /**
     * @inheritDoc
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onDestroy() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onStart() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onStop() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onResume() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onPause() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onConfigurationChanged(newConfig: Configuration) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return false
    }

    /**
     * @inheritDoc
     */
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        return true
    }

    /**
     * @inheritDoc
     */
    override fun onSaveInstanceState(bundle: Bundle) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onAttach(context: Context?) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onDetach() {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onPostCreate(savedInstanceState: Bundle?) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun onBackPressed(): Boolean {
        return false
    }

    /**
     * @inheritDoc
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        // Do nothing
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        // Do nothing
    }

    /**
     * @inheritDoc
     */
    override fun <Component> getComponent(componentClass: Class<Component>): Component? {
        return null
    }

    /**
     * @inheritDoc
     */
    override fun attachBaseContext(context: Context): Context {
        return context
    }

    /**
     * Equals is final, we explicitly want this and only this implementation
     *
     * As behaviours must be unique, its a class comparison
     *
     * @param other to compare to
     * @return true if same, false otherwise
     */
    override fun equals(other: Any?): Boolean {
        return other?.javaClass == javaClass
    }

    /**
     * We will use as a hash the string of the name, we dont want different instances of this class
     * living together. So we identify all classes as one
     * @return int with the hash, unique per class
     */
    override fun hashCode(): Int {
        return this.javaClass.name.hashCode()
    }

}