package com.nerdscorner.mvplib.events.behaviour

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import com.nerdscorner.mvplib.events.presenter.BasePresenter
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import org.greenrobot.eventbus.EventBus

@Parcelize
class MvpEventsBehaviour(val presenter: @RawValue BasePresenter<*, *>) : Behaviour() {

    override fun onStart() {
        super.onStart()
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        try {
            EventBus.getDefault().register(presenter)
        } catch (ignored: Exception) {
            //No @Subscribe annotations detected
        }

        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
        try {
            EventBus.getDefault().unregister(presenter)
        } catch (ignored: Exception) {
            //No @Subscribe annotations detected
        }

    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onBackPressed(): Boolean {
        return !presenter.onBackPressed() && super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return presenter.onCreateOptionsMenu(menu)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        presenter.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return !presenter.onOptionsItemSelected(item) && super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        presenter.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.onRestoreInstanceState(savedInstanceState)
    }

    override fun <Component> getComponent(componentClass: Class<Component>): Component? {
        return if (componentClass.isAssignableFrom(EventBus::class.java)) {
            EventBus.getDefault() as Component
        } else null
    }

}
