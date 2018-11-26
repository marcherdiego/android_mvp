package com.nerdscorner.mvplib.testapp.interfaces.attribute;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.nerdscorner.mvplib.testapp.R;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.model.AttributeMainModel;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.presenter.AttributeMainPresenter;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.view.AttributeMainView;

public class AttributeInterfacesMainActivity extends AppCompatActivity {

    private AttributeMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        presenter = new AttributeMainPresenter(
                new AttributeMainView(this),
                new AttributeMainModel()
        );
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        //Do something here
        presenter.onBackPressed();
    }
}
