package com.nerdscorner.mvplib.testapp.events.statesmachine

import android.content.Intent
import android.util.Log
import com.github.marcherdiego.mvp.transitions.domain.Event
import com.github.marcherdiego.mvp.transitions.domain.State
import com.github.marcherdiego.mvp.transitions.StatesMachine
import com.nerdscorner.mvplib.testapp.events.ui.activities.MainActivity
import com.nerdscorner.mvplib.testapp.events.ui.activities.TransitionsState2Activity
import com.nerdscorner.mvplib.testapp.events.ui.activities.TransitionsState3Activity

object AppStatesMachine : StatesMachine() {
    // States
    val state1 = State()
    val state2 = State()
    val state3 = State()

    // Event
    val event1 = Event()
    val event2 = Event()
    val event3 = Event()
    val event4 = Event()

    init {
        // Transitions
        addActivityTransition(state1, state2, event1) {
            startActivity(Intent(this, TransitionsState2Activity::class.java))
        }
        addActivityTransition(state1, state3, event2) {
            startActivity(Intent(this, TransitionsState3Activity::class.java))
            finish()
        }
        addActivityTransition(state2, state3, event3) {
            startActivity(Intent(this, TransitionsState3Activity::class.java))
            finish()
        }
        addTransition(state3, null, event4) {
            startActivity(
                Intent(this, MainActivity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
        }

        setOnEndListener {
            Log.v("AppStatesMachine", "End state reached")
        }

        // Initialization
        currentState = state1
    }
}
