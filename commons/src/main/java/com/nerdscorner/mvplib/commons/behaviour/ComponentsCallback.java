package com.nerdscorner.mvplib.commons.behaviour;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Public interface containing all possible callbacks the components have.
 */
public interface ComponentsCallback {

    /**
     * Mirror method for both {@link AppCompatActivity#onCreate(Bundle)} as well as {@link Fragment#onCreate(Bundle)}.
     *
     * @param savedInstanceState Check original documentation.
     */
    void onCreate(@Nullable final Bundle savedInstanceState);

    /**
     * Mirror method for both {@link AppCompatActivity#onDestroy()} as well as {@link Fragment#onDestroy()}.
     */
    void onDestroy();

    /**
     * Mirror method for both {@link AppCompatActivity#onStart()} as well as {@link Fragment#onStart()}.
     */
    void onStart();

    /**
     * Mirror method for both {@link AppCompatActivity#onStop()}  as well as {@link Fragment#onStop()}.
     */
    void onStop();

    /**
     * Mirror method for both {@link AppCompatActivity#onResume()}  as well as {@link Fragment#onResume()}.
     */
    void onResume();

    /**
     * Mirror method for both {@link AppCompatActivity#onPause()} as well as {@link Fragment#onPause()}.
     */
    void onPause();

    /**
     * Mirror method for both {@link AppCompatActivity#onConfigurationChanged(Configuration)} as well as {@link Fragment#onConfigurationChanged(Configuration)}.
     *
     * @param newConfig Check original documentation.
     */
    void onConfigurationChanged(@NonNull final Configuration newConfig);

    /**
     * Mirror method for both {@link AppCompatActivity#onOptionsItemSelected(MenuItem)} as well as {@link Fragment#onOptionsItemSelected(MenuItem)}.
     *
     * @param item Check original documentation.
     * @return Check original documentation.
     */
    boolean onOptionsItemSelected(@NonNull final MenuItem item);

    /**
     * Mirror method for both {@link AppCompatActivity#onPrepareOptionsMenu(Menu)} as well as {@link Fragment#onPrepareOptionsMenu(Menu)}.
     *
     * @param menu Check original documentation.
     * @return Check original documentation.
     */
    boolean onPrepareOptionsMenu(Menu menu);

    /**
     * Mirror method for both {@link AppCompatActivity#onSaveInstanceState(Bundle)} as well as {@link Fragment#onSaveInstanceState(Bundle)}.
     *
     * @param bundle Check original documentation.
     */
    void onSaveInstanceState(@NonNull final Bundle bundle);

    /**
     * Mirror method for {@link Fragment#onAttach(Context)}.
     * <p>
     * <strong>Important: This is for fragments only</strong>
     *
     * @param context Check original documentation.
     */
    void onAttach(@Nullable final Context context);

    /**
     * Mirror method for {@link Fragment#onDetach()}.
     *
     * <strong>Important: This is for fragments only</strong>
     */
    void onDetach();

    /**
     * Mirror method for {@link AppCompatActivity#onPostCreate(Bundle)}.
     * <p>
     * <strong>Important: This is for activities only</strong>
     *
     * @param savedInstanceState Check original documentation.
     */
    void onPostCreate(@Nullable final Bundle savedInstanceState);

    /**
     * Mirror method for {@link AppCompatActivity#onActivityResult(int, int, Intent)}.
     * <p>
     * <strong>Important: This is for activities only</strong>
     *
     * @param requestCode callee request code
     * @param resultCode  callee result code
     * @param data        callee data
     */
    void onActivityResult(int requestCode, int resultCode, Intent data);

    /**
     * Mirror method for {@link AppCompatActivity#onBackPressed()}.
     * Returns a boolean notifying if the event should be considered consumed or not
     * <p>
     * <strong>Important: This is for activities only</strong>
     * @return true if the event should be marked as consumed (hence its not called the context
     * onBackPressed) or false if it should be
     */
    boolean onBackPressed();

    /**
     * Mirror method for {@link AppCompatActivity#onRestoreInstanceState(Bundle)}.
     * <p>
     * <strong>Important: This is for activities only</strong>
     *
     * @param savedInstanceState Check original documentation.
     */
    void onRestoreInstanceState(@NonNull final Bundle savedInstanceState);

    /**
     * Mirror method for {@link AppCompatActivity#onRequestPermissionsResult(int, String[], int[])}.
     * <p>
     * <strong>Important: This is for activities only</strong>
     *
     * @param requestCode requestCode
     * @param permissions permissions
     * @param grantResults grantResults
     */
    void onRequestPermissionsResult(final int requestCode, @NonNull final String[] permissions, @NonNull final int[] grantResults);

    /**
     * Method for getting a component. The component is a java class so it can be whatever the
     * developer wants to. All inheritances should check that the parameter is of the same type
     * of the component/s they provide
     *
     * @param <Component> Component type expected
     * @param componentClass Check original documentation.
     * @return Component Check original documentation.
     */
    @Nullable
    @CheckResult
    <Component> Component getComponent(@NonNull Class<Component> componentClass);

    /**
     * Mirror method for {@link AppCompatActivity#setContentView(View, ViewGroup.LayoutParams)}.
     * <p>
     * <strong>Important: This is for activities only</strong>
     *
     * @param view Check original documentation.
     * @param params Check original documentation.
     * @return view to as content view on activity
     */
    @CheckResult
    @NonNull
    View setContentView(@NonNull final View view, @Nullable final ViewGroup.LayoutParams params);

    /**
     * Mirror method for {@link AppCompatActivity#attachBaseContext(Context)}.
     *
     * <p><strong>Important: This is for activities only</strong></p>
     *
     * @param context Check original documentation.
     * @return the new attached context
     */
    @CheckResult
    @NonNull
    Context attachBaseContext(@NonNull final Context context);
}