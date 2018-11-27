package com.nerdscorner.mvplib.testapp.events.attribute.fragments.view;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.view.BaseFragmentView;
import com.nerdscorner.mvplib.testapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fragment1View extends BaseFragmentView {
    @BindView(R.id.text) TextView text;

    public Fragment1View(@NonNull Fragment fragment, @NonNull Bus bus) {
        super(fragment, bus);
        ButterKnife.bind(this, fragment.getView());
    }

    public void setText(String text) {
        this.text.setText(text);
    }
}
