package com.nerdscorner.mvplib.events.presenter

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.CallSuper
import androidx.annotation.IdRes
import androidx.core.app.ActivityCompat
import androidx.core.content.PermissionChecker
import androidx.fragment.app.Fragment
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.events.utils.permissions.PermissionListener
import com.nerdscorner.mvplib.events.view.BaseView

abstract class BasePresenter<V : BaseView, M : BaseEventsModel>(
        @JvmField protected var view: V,
        @JvmField protected var model: M
) {

    private var currentRequestCode = 0x0100
    private val permissionRequestListeners = hashMapOf<Int, PermissionListener>()

    open fun onStart() {
    }

    open fun onResume() {
    }

    open fun onPause() {
    }

    open fun onStop() {
    }

    open fun onDestroyView() {
        view.unbind()
    }

    open fun onBackPressed() = false

    open fun onConfigurationChanged(newConfig: Configuration?) {}

    open fun onSaveInstanceState(outState: Bundle) {}

    open fun onCreateOptionsMenu(menu: Menu) = true

    open fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {}

    open fun onOptionsItemSelected(item: MenuItem?) = false

    open fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    @CallSuper
    open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        permissionRequestListeners.remove(requestCode)?.onResult()
    }

    open fun onRestoreInstanceState(savedInstanceState: Bundle?) {}

    fun startActivity(clazz: Class<out Activity>, bundle: Bundle? = null, finishCurrent: Boolean = false) {
        view.withActivity {
            val intent = Intent(this, clazz)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            startActivity(intent)
            if (finishCurrent) {
                finish()
            }
        }
    }

    fun replaceFragment(@IdRes containerViewId: Int, fragment: Fragment, commitNow: Boolean = true, tag: String? = null) {
        view.withFragmentByTag<Fragment>(tag) {
            fragmentReplace(containerViewId, this, commitNow, tag)
        } ?: run {
            fragmentReplace(containerViewId, fragment, commitNow, tag)
        }
    }

    private fun fragmentReplace(@IdRes containerViewId: Int, fragment: Fragment, commitNow: Boolean, tag: String?) {
        view.withFragmentTransaction {
            replace(containerViewId, fragment, tag)
            if (commitNow) {
                commitNow()
            } else {
                commit()
            }
        }
    }

    fun withPermission(permission: String, onGranted: () -> Unit) {
        withPermissions(arrayOf(permission), onGranted, {})
    }

    fun withPermission(permission: String, onGranted: () -> Unit, onDenied: (List<String>) -> Unit) {
        withPermissions(arrayOf(permission), onGranted, onDenied)
    }

    fun withPermissions(permissions: Array<out String>, onGranted: () -> Unit) {
        withPermissions(permissions, onGranted, {})
    }

    fun withPermissions(permissions: Array<out String>, onGranted: () -> Unit, onDenied: (List<String>) -> Unit) {
        view.withActivity {
            if (allPermissionsGranted(permissions)) {
                onGranted()
            } else {
                permissionRequestListeners[currentRequestCode] = object : PermissionListener {
                    override fun onResult() {
                        if (allPermissionsGranted(permissions)) {
                            onGranted()
                        } else {
                            onDenied(getDeniedPermissions(permissions))
                        }
                    }
                }
                ActivityCompat.requestPermissions(this, permissions, currentRequestCode)
                currentRequestCode++
            }
        }
    }

    fun isPermissionGranted(name: String): Boolean {
        return view.activity?.let {
            PermissionChecker.checkSelfPermission(it, name) == PermissionChecker.PERMISSION_GRANTED
        } ?: false
    }

    fun allPermissionsGranted(permissions: Array<out String>): Boolean {
        return view.activity?.let { activity ->
            permissions.all { permission ->
                PermissionChecker.checkSelfPermission(activity, permission) == PermissionChecker.PERMISSION_GRANTED
            }
        } ?: false
    }

    fun getDeniedPermissions(permissions: Array<out String>): List<String> {
        return view.activity?.let { activity ->
            permissions.filter { permission ->
                PermissionChecker.checkSelfPermission(activity, permission) != PermissionChecker.PERMISSION_GRANTED
            }
        } ?: emptyList()
    }
}
