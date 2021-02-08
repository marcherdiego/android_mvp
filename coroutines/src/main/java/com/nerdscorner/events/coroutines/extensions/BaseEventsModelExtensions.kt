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

fun <T> BaseEventsModel.launchMain(block: suspend () -> T) = CoroutineScope(Dispatchers.Main).launch {
    block()
}

fun <T> BaseEventsModel.runAsync(
        scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        block: suspend () -> T
): Deferred<T> {
    return scope.async(dispatcher) {
        block()
    }
}

fun <T> BaseEventsModel.withResult(
        scope: CoroutineScope = CoroutineScope(Dispatchers.Main),
        dispatcher: CoroutineDispatcher = Dispatchers.IO,
        resultFunc: suspend () -> T?,
        success: T?.() -> Unit,
        fail: Exception.() -> Unit = {},
        cancelled: () -> Unit = {}
): Job {
    return scope.launch {
        try {
            val result = withContext(scope.coroutineContext + dispatcher) {
                resultFunc()
            }
            ensureActive()
            success(result)
        } catch (e: Exception) {
            if (isActive) {
                fail(e)
            } else {
                cancelled()
            }
        }
    }
}
