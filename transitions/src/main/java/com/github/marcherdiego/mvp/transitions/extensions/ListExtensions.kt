package com.github.marcherdiego.mvp.transitions.extensions

fun <E> MutableList<E?>.addIf(predicate: () -> Boolean, element: E?) {
    if (predicate()) {
        add(element)
    }
}

fun <E> MutableList<E?>.addIf(condition: Boolean, element: E?) {
    addIf({ condition }, element)
}

fun <E> MutableList<E?>.addIfNotPresent(element: E?) {
    addIf({ contains(element).not() }, element)
}
