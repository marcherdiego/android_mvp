package com.nerdscorner.mvplib.commons.mvp.model

open class BaseModel {

    open fun onResume() {}

    open fun onPause() {}

    open fun onStart() {}

    open fun onStop() {}

    open fun onDestroy() {}

    open fun onDestroyView() {}
}