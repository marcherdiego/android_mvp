package com.nerdscorner.mvplib.testapp.interfaces.behaviour.view;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nerdscorner.mvplib.interfaces.view.BaseActivityView;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.presenter.BehaviourMainPresenterInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BehaviourMainView extends BaseActivityView<BehaviourMainPresenterInterface> implements BehaviourMainViewInterface {
    @BindView(R.id.text) TextView textView;

    public BehaviourMainView(AppCompatActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.some_button)
    public void onActionClicked() {
        getPresenter().onActionClicked();
    }

    @Override
    public void setTextValue(CharSequence value) {
        textView.setText(value);
    }
}
