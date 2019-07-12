package com.nerdscorner.mvplib.events.presenter

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.events.view.BaseView

abstract class BasePresenter<V : BaseView, M : BaseEventsModel>(
        @JvmField protected var view: V,
        @JvmField protected var model: M
) {

    open fun onStart() {
        view.onStart()
        model.onStart()
    }

    open fun onResume() {
        view.onResume()
        model.onResume()
    }

    open fun onPause() {
        view.onPause()
        model.onPause()
    }

    open fun onStop() {
        view.onStop()
        model.onStop()
    }

    open fun onDestroyView() {
        view.onDestroyView()
        view.unbind()
        model.onDestroyView()
    }

    open fun onBackPressed() = false

    open fun onConfigurationChanged(newConfig: Configuration?) {}

    open fun onSaveInstanceState(outState: Bundle) {}

    open fun onOptionsItemSelected(item: MenuItem?) = false

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {}

    open fun onRestoreInstanceState(savedInstanceState: Bundle?) {}
}
