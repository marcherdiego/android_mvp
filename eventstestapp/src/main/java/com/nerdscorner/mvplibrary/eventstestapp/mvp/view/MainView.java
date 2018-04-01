package com.nerdscorner.mvplibrary.eventstestapp.mvp.view;

import android.widget.TextView;

import com.nerdscorner.mvplib.events.activity.BaseActivity;
import com.nerdscorner.mvplib.events.view.BaseActivityView;
import com.nerdscorner.mvplibrary.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView extends BaseActivityView {
    @BindView(R.id.text) TextView textView;
    public MainView(BaseActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.some_button)
    public void onActionClicked() {
        bus.post(new ActionClickedEvent());
    }

    public void setTextValue(CharSequence value) {
        textView.setText(value);
    }

    public static class ActionClickedEvent {
    }
}
