package com.nerdscorner.events.coroutines.extensions

import com.nerdscorner.mvplib.events.model.BaseEventsModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.ensureActive
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Runs suspend a function on the main thread
 *
 * @param block suspend function to be executed on the main thread
 */
fun <T> BaseEventsModel.launchMain(block: suspend () -> T) = CoroutineScope(Dispatchers.Main).launch {
    block()
}

/**
 * Runs suspend a function on any scope/dispatcher (Main and IO by default)
 *
 * @param scope where the block will be executed in the async block
 * @param dispatcher to be used by the scope
 * @param block suspend function to be executed
 *
 * @return the [Deferred] task created
 */
fun <T> BaseEventsModel.runAsync(
        scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        block: suspend () -> T
): Deferred<T> {
    return scope.async(dispatcher) {
        block()
    }
}

/**
 * Runs suspend a function on any scope/dispatcher (Main and IO by default)
 *
 * @param scope where the resultFunc will be launched
 * @param dispatcher to be used by the scope
 * @param resultFunc suspend function to be executed
 * @param success function to be executed if `resultFunc` was executed successfully
 * @param fail function to be executed if `resultFunc` failed to execute
 * @param cancelled function to be executed if the job was cancelled
 *
 * @return the newly created [Job]
 */
fun <T> BaseEventsModel.withResult(
    scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
    dispatcher: CoroutineDispatcher = Dispatchers.IO,
    resultFunc: suspend () -> T?,
    success: T?.() -> Unit = {},
    fail: Exception.() -> Unit = {},
    cancelled: () -> Unit = {}
): Job {
    return scope.launch {
        try {
            val result = withContext(scope.coroutineContext + dispatcher) {
                resultFunc()
            }
            success(result)
        } catch (e: Exception) {
            e.printStackTrace()
            if (isActive) {
                fail(e)
            } else {
                cancelled()
            }
        }
    }
}
