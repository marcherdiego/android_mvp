package com.nerdscorner.mvplib.testapp.interfaces.attribute;

import android.os.Bundle;

import com.nerdscorner.mvplib.commons.behaviour.BaseActivity;
import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.model.AttributeMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.presenter.AttributeMainPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.view.AttributeMainView;

public class AttributeInterfacesMainActivity extends BaseActivity {

    private AttributeMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new AttributeMainPresenter(
                new AttributeMainView(this),
                new AttributeMainModel()
        );
    }
}
