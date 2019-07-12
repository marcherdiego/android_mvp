package com.nerdscorner.mvplib.events.config.annotations

annotation class RegistrationMode(
        @RegisterAt val registerAt: Int = RegisterAt.ON_RESUME,
        @UnregisterAt val unregisterAt: Int = UnregisterAt.ON_PAUSE
)
