package com.nerdscorner.mvplib.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.nerdscorner.mvplib.testapp.events.attribute.AttributeEventsMainActivity;
import com.nerdscorner.mvplib.testapp.events.behaviour.BehaviourEventsMainActivity;
import com.nerdscorner.mvplib.testapp.events.inheritance.InheritanceEventsMainActivity;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.AttributeInterfacesMainActivity;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.BehaviourInterfacesMainActivity;
import com.nerdscorner.mvplib.testapp.interfaces.inheritance.InheritanceInterfacesMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerToView(R.id.interfaces_behaviour, BehaviourInterfacesMainActivity.class);
        addListenerToView(R.id.interfaces_attributes, AttributeInterfacesMainActivity.class);
        addListenerToView(R.id.interfaces_inheritance, InheritanceInterfacesMainActivity.class);
        addListenerToView(R.id.events_behaviour, BehaviourEventsMainActivity.class);
        addListenerToView(R.id.events_attributes, AttributeEventsMainActivity.class);
        addListenerToView(R.id.events_inheritance, InheritanceEventsMainActivity.class);
    }

    private void addListenerToView(@IdRes int viewId, final Class destination) {
        findViewById(viewId).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), destination));
            }
        });
    }
}
