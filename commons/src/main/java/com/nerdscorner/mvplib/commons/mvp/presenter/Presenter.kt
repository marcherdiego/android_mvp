package com.nerdscorner.mvplib.commons.mvp.presenter

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.MenuItem

interface Presenter {

    fun onStart()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroyView()

    fun onBackPressed(): Boolean

    fun onConfigurationChanged(newConfig: Configuration?)

    fun onSaveInstanceState(outState: Bundle)

    fun onOptionsItemSelected(item: MenuItem?): Boolean

    fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)

    fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray)

    fun onRestoreInstanceState(savedInstanceState: Bundle?)
}
