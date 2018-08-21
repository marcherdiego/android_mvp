package com.nerdscorner.mvplib.commons.behaviour;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.RestrictTo;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Manager of behaviours.
 * This class is in charge of storing, attaching and notifying behaviours of a context lifecycle.
 */
@SuppressWarnings("PMD.GodClass")
@RestrictTo(RestrictTo.Scope.LIBRARY)
public final class BehaviourManager implements ComponentsCallback, Attachable, BehaviourCollection {

    private static final int TYPE_NOT_FOUND = -1;
    private static final int TYPE_FRAGMENT = 0;
    private static final int TYPE_ACTIVITY = 1;

    /**
     * The list of total behaviours containing both required and optional ones for each.
     * Note that there will only exist one behaviour instance for each class
     */
    private final Map<Class<? extends Behaviour>, Behaviour> behaviours;

    /**
     * Create this manager with all required behaviours.
     */
    public BehaviourManager() {
        behaviours = new HashMap<>();
        for (final Behaviour behaviour : RequiredBehaviours.create()) {
            if (!behaviours.containsKey(behaviour.getClass())) {
                behaviours.put(behaviour.getClass(), behaviour);
            }
        }
    }

    /**
     * Attach a context of an {@link AppCompatActivity} to the manager's behaviours.
     * @param activity the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void attach(@NonNull final AppCompatActivity activity) {
        attachInternal(activity);
    }

    /**
     * Attach a context of an {@link Fragment} to the manager's behaviours.
     * @param fragment the view where this behaviour is attached.
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void attach(@NonNull final Fragment fragment) {
        attachInternal(fragment);
    }

    /**
     * Internal attach process, where we do nasty things we are not proud of at least until
     * we decide how to decouple the different Contexts from the behaviours
     *
     * @param object to attach to all our behaviours
     */
    private void attachInternal(@NonNull final Object object) {
        int type = TYPE_NOT_FOUND;
        if (object instanceof Fragment) {
            type = TYPE_FRAGMENT;
        } else if (object instanceof AppCompatActivity) {
            type = TYPE_ACTIVITY;
        }

        if (type == TYPE_NOT_FOUND) {
            return;
        }

        for (final Behaviour behaviour : behaviours.values()) {
            if (type == TYPE_FRAGMENT) {
                behaviour.attach((Fragment) object);
            } else {
                behaviour.attach((AppCompatActivity) object);
            }
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    @CheckResult
    public boolean add(@NonNull final Behaviour behaviour) {
        if (behaviours.containsKey(behaviour.getClass())) {
            return false;
        }
        behaviours.put(behaviour.getClass(), behaviour);
        return true;
    }

    /**
     * Note that if the behaviour is a required one, it wont be removed.
     * @inheritDoc
     */
    @Override
    @CheckResult
    public boolean remove(@NonNull final Behaviour behaviour) {
        if (behaviours.get(behaviour.getClass()) == behaviour &&
            !RequiredBehaviours.contains(behaviour.getClass())) {
            behaviours.remove(behaviour.getClass());
            return true;
        }
        return false;
    }

    /**
     * @inheritDoc
     */
    @SuppressWarnings("unchecked")
    @Override
    @Nullable
    public <T extends Behaviour> T get(@NonNull final Class<T> type) {
        return (T) behaviours.get(type);
    }

    /**
     * @inheritDoc
     */
    @NonNull
    @Override
    public Iterator<Behaviour> iterator() {
        return behaviours.values().iterator();
    }

    /**
     * @inheritDoc
     */
    @RequiresApi(Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void forEach(@NonNull final Consumer<? super Behaviour> action) {
        behaviours.values().forEach(action);
    }

    /**
     * @inheritDoc
     */
    @RequiresApi(Build.VERSION_CODES.N)
    @TargetApi(Build.VERSION_CODES.N)
    @NonNull
    @Override
    public Spliterator<Behaviour> spliterator() {
        return behaviours.values().spliterator();
    }

    /**
     * @inheritDoc
     */
    @NonNull
    @CheckResult
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public Context attachBaseContext(@NonNull final Context context) {
        Context finalContext = context;
        for (final Behaviour behaviour : behaviours.values()) {
            finalContext = behaviour.attachBaseContext(finalContext);
        }
        return finalContext;
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onCreate(@Nullable final Bundle saveInstanceState) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onCreate(saveInstanceState);
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onDestroy() {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onDestroy();
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onStart() {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onStart();
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onStop() {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onStop();
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onResume() {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onResume();
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onAttach(@Nullable final Context context) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onAttach(context);
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onDetach() {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onDetach();
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onPostCreate(@Nullable final Bundle savedInstanceState) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onPostCreate(savedInstanceState);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onActivityResult(requestCode, resultCode, data);
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onPause() {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onPause();
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        boolean result = false;
        for (final Behaviour behaviour : behaviours.values()) {
            if (behaviour.onOptionsItemSelected(item)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public boolean onPrepareOptionsMenu(@NonNull final Menu item) {
        boolean result = true;
        for (final Behaviour behaviour : behaviours.values()) {
            result &= behaviour.onPrepareOptionsMenu(item);
        }
        return result;
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public boolean onBackPressed() {
        boolean result = false;
        for (final Behaviour behaviour : behaviours.values()) {
            if (behaviour.onBackPressed()) {
                result = true;
            }
        }
        return result;
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onConfigurationChanged(@NonNull final Configuration newConfig) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onConfigurationChanged(newConfig);
        }
    }

    /**
     * @inheritDoc
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public void onSaveInstanceState(@NonNull final Bundle outState) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onSaveInstanceState(outState);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public void onRestoreInstanceState(@NonNull final Bundle savedInstanceState) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onRestoreInstanceState(savedInstanceState);
        }
    }

    /**
     * @inheritDoc
     */
    @Override
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        for (final Behaviour behaviour : behaviours.values()) {
            behaviour.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }


    /**
     * @inheritDoc
     */
    @Nullable
    @CheckResult
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @Override
    public <Component> Component getComponent(@NonNull Class<Component> componentClass) {
        for (final Behaviour behaviour : behaviours.values()) {
            Component component = behaviour.getComponent(componentClass);
            if (component != null) {
                return component;
            }
        }
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    @CheckResult
    @RestrictTo(RestrictTo.Scope.LIBRARY)
    @NonNull
    public View setContentView(@NonNull final View view, @Nullable final ViewGroup.LayoutParams params) {
        View finalView = view;
        for (final Behaviour behaviour : behaviours.values()) {
            finalView = behaviour.setContentView(finalView, params);
        }
        return finalView;
    }

}