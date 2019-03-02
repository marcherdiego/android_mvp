package com.nerdscorner.mvplib.testapp.events.attribute.fragments.view;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.events.bus.Bus;
import com.nerdscorner.mvplib.events.view.BaseActivityView;
import com.nerdscorner.mvplib.testapp.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AttributeFragmentMainView extends BaseActivityView {

    public AttributeFragmentMainView(@NonNull AppCompatActivity activity, @NonNull Bus bus) {
        super(activity, bus);
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.next_fragment_btn)
    public void onNextFragmentClicked() {
        getBus().post(new NextFragmentClickedEvent());
    }

    public void setCurrentFragment(Fragment nextFragment) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.container, nextFragment);
        fragmentTransaction.commitNow();
    }

    public static class NextFragmentClickedEvent {
    }
}
