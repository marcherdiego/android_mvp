package com.nerdscorner.mvplib.events.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.events.view.BaseFragmentView
import kotlin.DeprecationLevel.WARNING

// BaseActivityView
@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.findFragmentByTag<T>(tag)", "com.nerdscorner.mvplib.events.view")
)
fun <T : Fragment> BaseActivityView.findFragmentByTag(tag: String) = fragmentManager?.findFragmentByTag(tag) as? T

@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.existsFragmentWithTag(tag)", "com.nerdscorner.mvplib.events.view")
)
fun BaseActivityView.existsFragmentWithTag(tag: String) = findFragmentByTag<Fragment>(tag) != null

@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.withFragmentByTag<T>(tag, block)", "com.nerdscorner.mvplib.events.view")
)
fun <T : Fragment> BaseActivityView.withFragmentByTag(tag: String, block: (fragment: T, fragmentManager: FragmentManager) -> Unit) {
    findFragmentByTag<T>(tag)?.run {
        block(this, fragmentManager ?: return)
    }
}

@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.withFragmentTransaction(block)", "com.nerdscorner.mvplib.events.view")
)
fun BaseActivityView.withFragmentTransaction(block: (transaction: FragmentTransaction) -> Unit) {
    block(fragmentManager?.beginTransaction() ?: return)
}

// BaseFragmentView
@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.findFragmentByTag<T>(tag)", "com.nerdscorner.mvplib.events.view")
)
fun <T : Fragment> BaseFragmentView.findFragmentByTag(tag: String) = fragmentManager?.findFragmentByTag(tag) as? T

@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.existsFragmentWithTag(tag)", "com.nerdscorner.mvplib.events.view")
)
fun BaseFragmentView.existsFragmentWithTag(tag: String) = findFragmentByTag<Fragment>(tag) != null

@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.withFragmentByTag<T>(tag, block)", "com.nerdscorner.mvplib.events.view")
)
fun <T : Fragment> BaseFragmentView.withFragmentByTag(tag: String, block: (fragment: T, fragmentManager: FragmentManager) -> Unit) {
    findFragmentByTag<T>(tag)?.run {
        block(this, fragmentManager ?: return)
    }
}

@Deprecated(
        message = "This function has been moved to BaseView",
        level = WARNING,
        replaceWith = ReplaceWith("view.withFragmentTransaction(block)", "com.nerdscorner.mvplib.events.view")
)
fun BaseFragmentView.withFragmentTransaction(block: (transaction: FragmentTransaction) -> Unit) {
    block(fragmentManager?.beginTransaction() ?: return)
}