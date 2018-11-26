package com.nerdscorner.mvplib.testapp.interfaces.inheritance.view;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.nerdscorner.mvplib.interfaces.view.BaseActivityView;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.presenter.InheritanceMainPresenterInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class InheritanceMainView extends BaseActivityView<InheritanceMainPresenterInterface> implements InheritanceMainViewInterface {
    @BindView(R.id.text) TextView textView;

    public InheritanceMainView(AppCompatActivity activity) {
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
