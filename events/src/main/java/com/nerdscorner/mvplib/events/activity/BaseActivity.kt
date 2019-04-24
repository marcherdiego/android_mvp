package com.nerdscorner.mvplib.events.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.nerdscorner.mvplib.events.config.MvpConfig
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt
import com.nerdscorner.mvplib.events.presenter.BaseActivityPresenter

open class BaseActivity<P : BaseActivityPresenter<*, *>> : AppCompatActivity() {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (MvpConfig.registerAt == RegisterAt.ON_CREATE) {
            presenter.bus.register(presenter)
        }
    }

    public override fun onStart() {
        super.onStart()
        if (MvpConfig.registerAt == RegisterAt.ON_START) {
            presenter.bus.register(presenter)
        }
        presenter.onStart()
    }

    public override fun onResume() {
        super.onResume()
        if (MvpConfig.registerAt == RegisterAt.ON_RESUME) {
            presenter.bus.register(presenter)
        }
        presenter.onResume()
    }

    public override fun onPause() {
        super.onPause()
        presenter.onPause()
        if (MvpConfig.unregisterAt == UnregisterAt.ON_PAUSE) {
            presenter.bus.unregister(presenter)
        }
    }

    public override fun onStop() {
        super.onStop()
        presenter.onStop()
        if (MvpConfig.unregisterAt == UnregisterAt.ON_STOP) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (MvpConfig.unregisterAt == UnregisterAt.ON_DESTROY) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onBackPressed() {
        if (!presenter.onBackPressed()) {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        return presenter.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return !presenter.onOptionsItemSelected(item) && super.onOptionsItemSelected(item)
    }

    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        presenter.onConfigurationChanged(newConfig)
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter.onRestoreInstanceState(savedInstanceState)
    }
}
