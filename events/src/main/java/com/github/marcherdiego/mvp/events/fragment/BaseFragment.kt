package com.github.marcherdiego.mvp.events.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.github.marcherdiego.mvp.events.config.annotations.RegisterAt
import com.github.marcherdiego.mvp.events.config.annotations.UnregisterAt
import com.github.marcherdiego.mvp.events.presenter.BaseFragmentPresenter

abstract class BaseFragment<P : BaseFragmentPresenter<*, *>>(
    @RegisterAt private val registerAt: Int = RegisterAt.ON_RESUME,
    @UnregisterAt private val unregisterAt: Int = UnregisterAt.ON_PAUSE
) : Fragment() {

    @JvmField
    var presenter: P? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        val presenter = presenter ?: return view
        presenter.onRestoreInstanceState(savedInstanceState)
        if (registerAt == RegisterAt.ON_CREATE) {
            presenter.bus.register(presenter)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        val presenter = presenter ?: return
        if (registerAt == RegisterAt.ON_START) {
            presenter.bus.register(presenter)
        }
        presenter.onStart()
    }

    override fun onResume() {
        super.onResume()
        val presenter = presenter ?: return
        if (registerAt == RegisterAt.ON_RESUME) {
            presenter.bus.register(presenter)
        }
        presenter.onResume()
    }

    override fun onPause() {
        super.onPause()
        val presenter = presenter ?: return
        presenter.onPause()
        if (unregisterAt == UnregisterAt.ON_PAUSE) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onStop() {
        super.onStop()
        val presenter = presenter ?: return
        presenter.onStop()
        if (unregisterAt == UnregisterAt.ON_STOP) {
            presenter.bus.unregister(presenter)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        val presenter = presenter ?: return
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
        presenter?.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        presenter?.onOptionsItemSelected(item) == false && super.onOptionsItemSelected(item)

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        presenter?.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        presenter?.onSaveInstanceState(outState)
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter?.onViewStateRestored(savedInstanceState)
    }

    @Deprecated("Deprecated in Java")
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        presenter?.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}
