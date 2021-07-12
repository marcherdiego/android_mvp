package com.github.marcherdiego.mvp.transitions

data class Event(val id: Int = autoIncrement++) {
    companion object {
        private var autoIncrement = 0
    }
}
