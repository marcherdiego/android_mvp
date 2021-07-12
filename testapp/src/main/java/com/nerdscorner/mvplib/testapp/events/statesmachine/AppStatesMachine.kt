package com.nerdscorner.mvplib.testapp.events.statesmachine

import android.content.Intent
import com.github.marcherdiego.mvp.transitions.Event
import com.github.marcherdiego.mvp.transitions.State
import com.github.marcherdiego.mvp.transitions.StatesMachine
import com.nerdscorner.mvplib.testapp.events.ui.activities.TransitionsState1Activity
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
    val event5 = Event()

    init {
        // Transitions
        addTransition(state1, state2, event1) {
            startActivity(Intent(this, TransitionsState2Activity::class.java))
        }
        addTransition(state1, state3, event2) {
            startActivity(Intent(this, TransitionsState3Activity::class.java))
        }
        addTransition(state2, state3, event3) {
            startActivity(Intent(this, TransitionsState3Activity::class.java))
        }
        addTransition(state3, state1, event4) {
            startActivity(
                Intent(this, TransitionsState1Activity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            )
        }
        addTransition(state3, null, event5)

        // Initialization
        currentState = state1
    }
}
