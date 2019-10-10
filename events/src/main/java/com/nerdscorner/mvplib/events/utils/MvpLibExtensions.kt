package com.nerdscorner.mvplib.events.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.nerdscorner.mvplib.events.view.BaseActivityView
import com.nerdscorner.mvplib.events.view.BaseFragmentView

// BaseActivityView
fun <T : Fragment> BaseActivityView.findFragmentByTag(tag: String) = fragmentManager?.findFragmentByTag(tag) as? T

fun BaseActivityView.existsFragmentWithTag(tag: String) = findFragmentByTag<Fragment>(tag) != null

fun <T : Fragment> BaseActivityView.withFragmentByTag(tag: String, block: (fragment: T, fragmentManager: FragmentManager) -> Unit) {
    findFragmentByTag<T>(tag)?.run {
        block(this, fragmentManager ?: return)
    }
}

fun BaseActivityView.withFragmentTransaction(block: (transaction: FragmentTransaction) -> Unit) {
    block(fragmentManager?.beginTransaction() ?: return)
}

// BaseFragmentView
fun <T : Fragment> BaseFragmentView.findFragmentByTag(tag: String) = fragmentManager?.findFragmentByTag(tag) as? T

fun BaseFragmentView.existsFragmentWithTag(tag: String) = findFragmentByTag<Fragment>(tag) != null

fun <T : Fragment> BaseFragmentView.withFragmentByTag(tag: String, block: (fragment: T, fragmentManager: FragmentManager) -> Unit) {
    findFragmentByTag<T>(tag)?.run {
        block(this, fragmentManager ?: return)
    }
}

fun BaseFragmentView.withFragmentTransaction(block: (transaction: FragmentTransaction) -> Unit) {
    block(fragmentManager?.beginTransaction() ?: return)
}