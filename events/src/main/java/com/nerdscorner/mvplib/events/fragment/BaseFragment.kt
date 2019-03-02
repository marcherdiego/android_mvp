package com.nerdscorner.mvplib.events.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.*
import com.nerdscorner.mvplib.events.config.MvpConfig
import com.nerdscorner.mvplib.events.config.MvpConfig.RegisterAt
import com.nerdscorner.mvplib.events.config.MvpConfig.UnregisterAt
import com.nerdscorner.mvplib.events.presenter.BaseFragmentPresenter

abstract class BaseFragment<P : BaseFragmentPresenter<*, *>> : Fragment() {

    var presenter: P? = null
        get() {
            if (field == null) {
                Log.w(BaseFragment.TAG, "Presenter is null, did you missed to initialise it?")
            }
            return field
        }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = super.onCreateView(inflater, container, savedInstanceState)
        if (MvpConfig.registerAt == RegisterAt.ON_CREATE) {
            presenter?.bus?.register(presenter)
        }
        return view
    }

    override fun onStart() {
        super.onStart()
        if (MvpConfig.registerAt == RegisterAt.ON_START) {
            presenter?.bus?.register(presenter)
        }
        presenter?.onStart()
    }

    override fun onResume() {
        super.onResume()
        if (MvpConfig.registerAt == RegisterAt.ON_RESUME) {
            presenter?.bus?.register(presenter)
        }
        presenter?.onResume()
    }

    override fun onPause() {
        super.onPause()
        presenter?.onPause()
        if (MvpConfig.unregisterAt == UnregisterAt.ON_PAUSE) {
            presenter?.bus?.unregister(presenter)
        }
    }

    override fun onStop() {
        super.onStop()
        presenter?.onStop()
        if (MvpConfig.unregisterAt == UnregisterAt.ON_STOP) {
            presenter?.bus?.unregister(presenter)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        try {
            presenter?.onDestroyView()
            if (MvpConfig.unregisterAt == UnregisterAt.ON_DESTROY) {
                presenter?.bus?.unregister(presenter)
            }
        } catch (ignored: Exception) {
        } finally {
            presenter = null
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        presenter?.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return presenter?.onOptionsItemSelected(item) == false && super.onOptionsItemSelected(item)
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        presenter?.onConfigurationChanged(newConfig)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (presenter != null) {
            presenter?.onSaveInstanceState(outState)
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        presenter?.onViewStateRestored(savedInstanceState)
    }

    companion object {
        const val TAG = "Base Fragment"
    }
}
