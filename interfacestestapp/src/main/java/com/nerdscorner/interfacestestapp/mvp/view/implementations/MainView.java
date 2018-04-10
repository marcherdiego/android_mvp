package com.nerdscorner.interfacestestapp.mvp.view.implementations;

import android.widget.TextView;

import com.nerdscorner.interfacestestapp.R;
import com.nerdscorner.interfacestestapp.mvp.presenter.implementations.MainPresenter;
import com.nerdscorner.interfacestestapp.mvp.view.interfaces.MainViewInterface;
import com.nerdscorner.mvplib.interfaces.activity.BaseActivity;
import com.nerdscorner.mvplib.interfaces.view.BaseActivityView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainView extends BaseActivityView<MainPresenter> implements MainViewInterface {
    @BindView(R.id.text) TextView textView;

    public MainView(BaseActivity activity) {
        super(activity);
        ButterKnife.bind(this, activity);
    }

    @OnClick(R.id.some_button)
    public void onActionClicked() {
        presenter.onActionClicked();
    }

    @Override
    public void setTextValue(CharSequence value) {
        textView.setText(value);
    }
}
