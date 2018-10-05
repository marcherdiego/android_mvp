package com.nerdscorner.mvplib.commons.behaviour;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public abstract class BaseActivity extends AppCompatActivity {

    private BehaviourManager behaviourManager;

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void attachBaseContext(@NonNull final Context newBase) {
        if (behaviourManager == null) {
            behaviourManager = new BehaviourManager();
            onBehavioursCreated(behaviourManager);
            behaviourManager.attach(this);
        }
        super.attachBaseContext(behaviourManager.attachBaseContext(newBase));
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        behaviourManager.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(final int layoutResID) {
        super.setContentView(behaviourManager.setContentView(
                LayoutInflater
                        .from(this)
                        .inflate(layoutResID, null, false),
                null)
        );
    }

    @Override
    public void setContentView(final View view) {
        super.setContentView(behaviourManager.setContentView(view, null));
    }

    @Override
    public void setContentView(final View view, final ViewGroup.LayoutParams params) {
        super.setContentView(behaviourManager.setContentView(view, params), params);
    }

    /**
     * Get the behaviour collection.
     *
     * @return the attached behaviour collection corresponding to this activity
     */
    @CheckResult
    @NonNull
    protected final BehaviourCollection getBehaviourCollection() {
        if (behaviourManager == null) {
            throw new IllegalStateException("Behaviour manager not yet created");
        }
        return new BehaviourCollectionProxy(behaviourManager, this);
    }

    /**
     * Adds the {@link Behaviour} to the behaviours collection.
     *
     * @param behaviour to be added
     * @return true if it was added, false otherwise
     */
    protected final boolean addBehaviour(@NonNull Behaviour behaviour) {
        return getBehaviourCollection().add(behaviour);
    }

    /**
     * Lifecycle method to customize your behaviours, this will be called as soon as the
     * behaviour collection is created
     *
     * @param behaviourCollection attached to this activity
     */
    @SuppressWarnings("PMD.EmptyMethodInAbstractClassShouldBeAbstract")
    protected void onBehavioursCreated(@NonNull final BehaviourCollection behaviourCollection) {
        // Do nothing
    }

    /**
     * It will first delegate to the behaviour manager. If no behaviour can provide
     * a service name for this class, it will return null
     *
     * @param componentClass class of the component you are expecting to receive an instance
     * @param <Component>    instance you are expecting to receive
     * @return Component instance of the provided component class
     */
    @CheckResult
    @Nullable
    public final <Component> Component getComponent(@NonNull Class<Component> componentClass) {
        return behaviourManager.getComponent(componentClass);
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onSaveInstanceState(final Bundle outState) {
        behaviourManager.onSaveInstanceState(outState);
        super.onSaveInstanceState(outState);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected void onRestoreInstanceState(final Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        behaviourManager.onRestoreInstanceState(savedInstanceState);
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onDestroy() {
        behaviourManager.onDestroy();
        super.onDestroy();
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onStart() {
        super.onStart();
        behaviourManager.onStart();
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onStop() {
        behaviourManager.onStop();
        super.onStop();
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onResume() {
        super.onResume();
        behaviourManager.onResume();
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onPause() {
        behaviourManager.onPause();
        super.onPause();
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    public void onBackPressed() {
        if (!behaviourManager.onBackPressed()) {
            super.onBackPressed();
        }
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onPostCreate(@Nullable final Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        behaviourManager.onPostCreate(savedInstanceState);
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    public void onConfigurationChanged(@NonNull final Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        behaviourManager.onConfigurationChanged(newConfig);
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        behaviourManager.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    public boolean onOptionsItemSelected(@NonNull final MenuItem item) {
        return behaviourManager.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @CallSuper
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        return behaviourManager.onPrepareOptionsMenu(menu) && super.onPrepareOptionsMenu(menu);
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        behaviourManager.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * Proxy class for a "runtime" activity behaviour collection
     */
    @SuppressWarnings("CPD-START")
    /* default */ static final class BehaviourCollectionProxy implements BehaviourCollection {

        @NonNull
        private final BehaviourCollection proxy;

        @NonNull
        private final WeakReference<AppCompatActivity> contextRef;

        /**
         * Package class constructor, using the proxy to forward the operation and the context
         * to attach as this is "runtime"
         *
         * @param proxy   to forward
         * @param context to attach
         */
        /* default */ BehaviourCollectionProxy(@NonNull final BehaviourCollection proxy, @NonNull final AppCompatActivity context) {
            this.proxy = proxy;
            this.contextRef = new WeakReference<>(context);
        }

        /**
         * @inheritDoc
         */
        @Override
        public boolean add(@NonNull final Behaviour behaviour) {
            behaviour.attach(contextRef.get());
            return proxy.add(behaviour);
        }

        /**
         * @inheritDoc
         */
        @Override
        public boolean remove(@NonNull final Behaviour behaviour) {
            return proxy.remove(behaviour);
        }

        /**
         * @inheritDoc
         */
        @Nullable
        @Override
        public <T extends Behaviour> T get(@NonNull final Class<T> type) {
            return proxy.get(type);
        }

        /**
         * @inheritDoc
         */
        @NonNull
        @Override
        public Iterator<Behaviour> iterator() {
            return proxy.iterator();
        }

        /**
         * @inheritDoc
         */
        @RequiresApi(Build.VERSION_CODES.N)
        @TargetApi(Build.VERSION_CODES.N)
        @Override
        public void forEach(@NonNull final Consumer<? super Behaviour> action) {
            proxy.forEach(action);
        }

        /**
         * @inheritDoc
         */
        @RequiresApi(Build.VERSION_CODES.N)
        @TargetApi(Build.VERSION_CODES.N)
        @NonNull
        @Override
        public Spliterator<Behaviour> spliterator() {
            return proxy.spliterator();
        }

    }
}
