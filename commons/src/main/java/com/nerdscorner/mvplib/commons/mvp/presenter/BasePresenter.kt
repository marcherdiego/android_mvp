package com.nerdscorner.mvplib.commons.mvp.presenter

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem

import com.nerdscorner.mvplib.commons.mvp.model.BaseModel
import com.nerdscorner.mvplib.commons.mvp.view.BaseView

abstract class BasePresenter<V : BaseView, M : BaseModel>(
        protected var view: V,
        protected var model: M
) : com.nerdscorner.mvplib.commons.mvp.presenter.Presenter {

    override fun onStart() {
        view.onStart()
        model.onStart()
    }

    override fun onResume() {
        view.onResume()
        model.onResume()
    }

    override fun onPause() {
        view.onPause()
        model.onPause()
    }

    override fun onStop() {
        view.onStop()
        model.onStop()
    }

    override fun onDestroyView() {
        view.onDestroyView()
        view.unbind()
        model.onDestroyView()
    }

    override fun onBackPressed(): Boolean {
        return false
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {}

    override fun onSaveInstanceState(outState: Bundle) {}

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return false
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {}

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {}
}
