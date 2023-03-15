package com.github.marcherdiego.mvp.testapp.ui.widgets

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.github.marcherdiego.mvp.testapp.R
import com.github.marcherdiego.mvp.testapp.ui.mvp.model.SampleWidgetModel
import com.github.marcherdiego.mvp.testapp.ui.mvp.presenter.SampleWidgetPresenter
import com.github.marcherdiego.mvp.testapp.ui.mvp.view.SampleWidgetView

class SampleWidget @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private var presenter = SampleWidgetPresenter(
        SampleWidgetView(this),
        SampleWidgetModel()
    )

    init {
        LayoutInflater
            .from(context)
            .inflate(R.layout.sample_widget_layout, this, true)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        presenter.onAttached()
    }

    override fun onDetachedFromWindow() {
        presenter.onDetached()
        super.onDetachedFromWindow()
    }
}
