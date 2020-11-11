package com.nerdscorner.mvplib.events.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nerdscorner.mvplib.events.config.annotations.RegisterAt
import com.nerdscorner.mvplib.events.config.annotations.UnregisterAt
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter

abstract class BaseFragment<P : BaseFragmentPresenter<*, *>>(
        @RegisterAt private val registerAt: Int = RegisterAt.ON_RESUME,
        @UnregisterAt private val unregisterAt: Int = UnregisterAt.ON_PAUSE
) : Fragment() {

    lateinit var presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.onRestoreInstanceState(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        if (registerAt == RegisterAt.ON_CREATE) {
            presenter.bus.register(presenter)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        if (registerAt == RegisterAt.ON_START) {
            presenter.bus.register(presenter)
        }
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        if (registerAt == RegisterAt.ON_RESUME) {
            presenter.bus.register(presenter)
        }
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
        if (unregisterAt == UnregisterAt.ON_PAUSE) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
        if (unregisterAt == UnregisterAt.ON_STOP) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            presenter.onDestroyView()
            if (unregisterAt == UnregisterAt.ON_DESTROY) {
                presenter.bus.unregister(presenter)
            }
        } catch (_: Exception) {
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        presenter.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem) = !presenter.onOptionsItemSelected(item) && super.onOptionsItemSelected(item)

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        presenter.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter.onViewStateRestored(savedInstanceState)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
