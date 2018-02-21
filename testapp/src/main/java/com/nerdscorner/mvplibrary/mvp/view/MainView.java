package com.nerdscorner.mvplibrary.mvp.view;

import android.widget.TextView;

import com.nerdscorner.mvplib.activity.BaseActivity;
import com.nerdscorner.mvplib.view.BaseActivityView;
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
        bus.post(ActionClickedEvent.class);
    }

    public void setTextValue(CharSequence value) {
        textView.setText(value);
    }

    public static class ActionClickedEvent {
    }
}
