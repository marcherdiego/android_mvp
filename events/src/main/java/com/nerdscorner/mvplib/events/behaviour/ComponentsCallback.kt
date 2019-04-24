package com.nerdscorner.mvplib.events.behaviour

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CheckResult

/**
 * Public interface containing all possible callbacks the components have.
 */
interface ComponentsCallback {

    /**
     * Mirror method for both [AppCompatActivity.onCreate] as well as [Fragment.onCreate].
     *
     * @param savedInstanceState Check original documentation.
     */
    fun onCreate(savedInstanceState: Bundle?)

    /**
     * Mirror method for both [AppCompatActivity.onDestroy] as well as [Fragment.onDestroy].
     */
    fun onDestroy()

    /**
     * Mirror method for both [AppCompatActivity.onStart] as well as [Fragment.onStart].
     */
    fun onStart()

    /**
     * Mirror method for both [AppCompatActivity.onStop]  as well as [Fragment.onStop].
     */
    fun onStop()

    /**
     * Mirror method for both [AppCompatActivity.onResume]  as well as [Fragment.onResume].
     */
    fun onResume()

    /**
     * Mirror method for both [AppCompatActivity.onPause] as well as [Fragment.onPause].
     */
    fun onPause()

    /**
     * Mirror method for both [AppCompatActivity.onConfigurationChanged] as well as [Fragment.onConfigurationChanged].
     *
     * @param newConfig Check original documentation.
     */
    fun onConfigurationChanged(newConfig: Configuration)

    /**
     * Mirror method for both [AppCompatActivity.onOptionsItemSelected] as well as [Fragment.onOptionsItemSelected].
     *
     * @param item Check original documentation.
     * @return Check original documentation.
     */
    fun onOptionsItemSelected(item: MenuItem): Boolean

    /**
     * Mirror method for both [AppCompatActivity.onPrepareOptionsMenu] as well as [Fragment.onPrepareOptionsMenu].
     *
     * @param menu Check original documentation.
     * @return Check original documentation.
     */
    fun onPrepareOptionsMenu(menu: Menu): Boolean

    /**
     * Mirror method for both [AppCompatActivity.onSaveInstanceState] as well as [Fragment.onSaveInstanceState].
     *
     * @param bundle Check original documentation.
     */
    fun onSaveInstanceState(bundle: Bundle)

    /**
     * Mirror method for [Fragment.onAttach].
     *
     *
     * **Important: This is for fragments only**
     *
     * @param context Check original documentation.
     */
    fun onAttach(context: Context?)

    /**
     * Mirror method for [Fragment.onDetach].
     *
     * **Important: This is for fragments only**
     */
    fun onDetach()

    /**
     * Mirror method for [AppCompatActivity.onPostCreate].
     *
     *
     * **Important: This is for activities only**
     *
     * @param savedInstanceState Check original documentation.
     */
    fun onPostCreate(savedInstanceState: Bundle?)

    /**
     * Mirror method for [AppCompatActivity.onActivityResult].
     *
     *
     * **Important: This is for activities only**
     *
     * @param requestCode callee request code
     * @param resultCode  callee result code
     * @param data        callee data
     */
    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

    /**
     * Mirror method for [AppCompatActivity.onBackPressed].
     * Returns a boolean notifying if the event should be considered consumed or not
     *
     *
     * **Important: This is for activities only**
     * @return true if the event should be marked as consumed (hence its not called the context
     * onBackPressed) or false if it should be
     */
    fun onBackPressed(): Boolean

    /**
     * Mirror method for [AppCompatActivity.onRestoreInstanceState].
     *
     *
     * **Important: This is for activities only**
     *
     * @param savedInstanceState Check original documentation.
     */
    fun onRestoreInstanceState(savedInstanceState: Bundle)

    /**
     * Mirror method for [AppCompatActivity.onRequestPermissionsResult].
     *
     *
     * **Important: This is for activities only**
     *
     * @param requestCode requestCode
     * @param permissions permissions
     * @param grantResults grantResults
     */
    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray)

    /**
     * Method for getting a component. The component is a java class so it can be whatever the
     * developer wants to. All inheritances should check that the parameter is of the same type
     * of the component/s they provide
     *
     * @param <Component> Component type expected
     * @param componentClass Check original documentation.
     * @return Component Check original documentation.
    </Component> */
    @CheckResult
    fun <Component> getComponent(componentClass: Class<Component>): Component?

    /**
     * Mirror method for [AppCompatActivity.setContentView].
     *
     *
     * **Important: This is for activities only**
     *
     * @param view Check original documentation.
     * @param params Check original documentation.
     * @return view to as content view on activity
     */
    @CheckResult
    fun setContentView(view: View, params: ViewGroup.LayoutParams?): View

    /**
     * Mirror method for [AppCompatActivity.attachBaseContext].
     *
     *
     * **Important: This is for activities only**
     *
     * @param context Check original documentation.
     * @return the new attached context
     */
    @CheckResult
    fun attachBaseContext(context: Context): Context
}