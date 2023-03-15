package com.github.marcherdiego.mvp.events.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.github.marcherdiego.mvp.events.config.annotations.RegisterAt
import com.github.marcherdiego.mvp.events.config.annotations.UnregisterAt
import com.github.marcherdiego.mvp.events.presenter.BaseActivityPresenter

open class BaseActivity<P : BaseActivityPresenter<*, *>>(
    @RegisterAt private val registerAt: Int = RegisterAt.ON_RESUME,
    @UnregisterAt private val unregisterAt: Int = UnregisterAt.ON_PAUSE
) : AppCompatActivity() {

    @JvmField
    var presenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val presenter = presenter ?: return
        if (registerAt == RegisterAt.ON_CREATE) {
            presenter.bus.register(presenter)
        }
    }

    public override fun onStart() {
        super.onStart()
        val presenter = presenter ?: return
        if (registerAt == RegisterAt.ON_START) {
            presenter.bus.register(presenter)
        }
        presenter.onStart()
    }

    public override fun onResume() {
        super.onResume()
        val presenter = presenter ?: return
        if (registerAt == RegisterAt.ON_RESUME) {
            presenter.bus.register(presenter)
        }
        presenter.onResume()
    }

    public override fun onPause() {
        super.onPause()
        val presenter = presenter ?: return
        presenter.onPause()
        if (unregisterAt == UnregisterAt.ON_PAUSE) {
            presenter.bus.unregister(presenter)
        }
    }

    public override fun onStop() {
        super.onStop()
        val presenter = presenter ?: return
        presenter.onStop()
        if (unregisterAt == UnregisterAt.ON_STOP) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        val presenter = presenter ?: return
        presenter.onDestroy()
        if (unregisterAt == UnregisterAt.ON_DESTROY) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onBackPressed() {
        if (presenter?.onBackPressed() == false) {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu) = presenter?.onCreateOptionsMenu(menu) == true

    override fun onOptionsItemSelected(item: MenuItem) =
        presenter?.onOptionsItemSelected(item) == false && super.onOptionsItemSelected(item)

    @Deprecated("Deprecated in Java")
    public override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        presenter?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        presenter?.onConfigurationChanged(newConfig)
    }

    public override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter?.onSaveInstanceState(outState)
    }

    public override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        presenter?.onRestoreInstanceState(savedInstanceState)
    }
}
