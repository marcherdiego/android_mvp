package com.nerdscorner.mvplib.testapp.events.view;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nerdscorner.mvplib.events.view.BaseActivityView;
import com.nerdscorner.mvplib.testapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView extends BaseActivityView {
    @BindView(R.id.text) TextView textView;

    public MainView(AppCompatActivity activity) {
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
