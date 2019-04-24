package com.nerdscorner.mvplib.events.behaviour

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.CheckResult
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import java.lang.ref.WeakReference
import java.util.Spliterator
import java.util.function.Consumer

abstract class BaseActivity : AppCompatActivity() {

    private var behaviourManager: BehaviourManager? = null

    /**
     * Get the behaviour collection.
     *
     * @return the attached behaviour collection corresponding to this activity
     */
    protected val behaviourCollection: BehaviourCollection
        @CheckResult
        get() {
            behaviourManager?.let {
                return BehaviourCollectionProxy(it, this)
            } ?: run {
                throw IllegalStateException("Behaviour manager not yet created")
            }
        }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun attachBaseContext(newBase: Context) {
        if (behaviourManager == null) {
            behaviourManager = BehaviourManager()
            onBehavioursCreated(behaviourManager!!)
            behaviourManager?.attach(this)
        }
        super.attachBaseContext(behaviourManager?.attachBaseContext(newBase))
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        behaviourManager?.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(behaviourManager?.setContentView(
                LayoutInflater
                        .from(this)
                        .inflate(layoutResID, null, false), null)
        )
    }

    override fun setContentView(view: View) {
        super.setContentView(behaviourManager?.setContentView(view, null))
    }

    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
        super.setContentView(behaviourManager?.setContentView(view, params), params)
    }

    /**
     * Adds the [Behaviour] to the behaviours collection.
     *
     * @param behaviour to be added
     * @return true if it was added, false otherwise
     */
    protected fun addBehaviour(behaviour: Behaviour): Boolean {
        return behaviourCollection.add(behaviour)
    }

    /**
     * Lifecycle method to customize your behaviours, this will be called as soon as the
     * behaviour collection is created
     *
     * @param behaviourCollection attached to this activity
     */
    protected fun onBehavioursCreated(behaviourCollection: BehaviourCollection) {
        // Do nothing
    }

    /**
     * It will first delegate to the behaviour manager. If no behaviour can provide
     * a service name for this class, it will return null
     *
     * @param componentClass class of the component you are expecting to receive an instance
     * @param <Component>    instance you are expecting to receive
     * @return Component instance of the provided component class
    </Component> */
    @CheckResult
    fun <Component> getComponent(componentClass: Class<Component>): Component? {
        return behaviourManager?.getComponent(componentClass)
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        behaviourManager?.onSaveInstanceState(outState)
        super.onSaveInstanceState(outState)
    }

    /**
     * @inheritDoc
     */
    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        behaviourManager?.onRestoreInstanceState(savedInstanceState)
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onDestroy() {
        behaviourManager?.onDestroy()
        super.onDestroy()
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onStart() {
        super.onStart()
        behaviourManager?.onStart()
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onStop() {
        behaviourManager?.onStop()
        super.onStop()
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onResume() {
        super.onResume()
        behaviourManager?.onResume()
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onPause() {
        behaviourManager?.onPause()
        super.onPause()
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onBackPressed() {
        if (behaviourManager?.onBackPressed() == false) {
            super.onBackPressed()
        }
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        behaviourManager?.onPostCreate(savedInstanceState)
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        behaviourManager?.onConfigurationChanged(newConfig)
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        behaviourManager?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return behaviourManager?.onOptionsItemSelected(item) == true || super.onOptionsItemSelected(item)
    }

    @CallSuper
    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        return behaviourManager?.onPrepareOptionsMenu(menu) == true && super.onPrepareOptionsMenu(menu)
    }

    /**
     * @inheritDoc
     */
    @CallSuper
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        behaviourManager?.onActivityResult(requestCode, resultCode, data)
    }

    /**
     * Proxy class for a "runtime" activity behaviour collection
     */
    internal/* default */ class BehaviourCollectionProxy
    /**
     * Package class constructor, using the proxy to forward the operation and the context
     * to attach as this is "runtime"
     *
     * @param proxy   to forward
     * @param context to attach
     */
    /* default */(private val proxy: BehaviourCollection, context: AppCompatActivity) : BehaviourCollection {

        private val contextRef: WeakReference<AppCompatActivity>

        init {
            this.contextRef = WeakReference(context)
        }

        /**
         * @inheritDoc
         */
        override fun add(behaviour: Behaviour): Boolean {
            contextRef.get()?.let {
                behaviour.attach(it)
                return proxy.add(behaviour)
            }
            return false
        }

        /**
         * @inheritDoc
         */
        override fun remove(behaviour: Behaviour): Boolean {
            return proxy.remove(behaviour)
        }

        /**
         * @inheritDoc
         */
        override fun <T : Behaviour> get(type: Class<T>): T? {
            return proxy.get(type)
        }

        /**
         * @inheritDoc
         */
        override fun iterator(): Iterator<Behaviour> {
            return proxy.iterator()
        }

        /**
         * @inheritDoc
         */
        @RequiresApi(Build.VERSION_CODES.N)
        @TargetApi(Build.VERSION_CODES.N)
        override fun forEach(action: Consumer<in Behaviour>) {
            proxy.forEach(action)
        }

        /**
         * @inheritDoc
         */
        @RequiresApi(Build.VERSION_CODES.N)
        @TargetApi(Build.VERSION_CODES.N)
        override fun spliterator(): Spliterator<Behaviour> {
            return proxy.spliterator()
        }

    }
}
