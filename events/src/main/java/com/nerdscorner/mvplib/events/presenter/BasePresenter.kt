package com.nerdscorner.mvplib.events.presenter

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.nerdscorner.mvplib.events.model.BaseEventsModel
import com.nerdscorner.mvplib.events.view.BaseView

abstract class BasePresenter<V : BaseView, M : BaseEventsModel>(
        @JvmField protected var view: V,
        @JvmField protected var model: M
) {

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

    open fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {}

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

    fun replaceFragment(@IdRes containerViewId: Int, fragment: Fragment, commitNow: Boolean = true) {
        view.withFragmentTransaction {
            replace(containerViewId, fragment)
            if (commitNow) {
                commitNow()
            } else {
                commit()
            }
        }
    }
}
