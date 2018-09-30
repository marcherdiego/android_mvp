package com.nerdscorner.mvplib.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.nerdscorner.mvplib.testapp.events.attribute.AttributeEventsMainActivity;
import com.nerdscorner.mvplib.testapp.events.behaviour.BehaviourEventsMainActivity;
import com.nerdscorner.mvplib.testapp.interfaces.attribute.AttributeInterfacesMainActivity;
import com.nerdscorner.mvplib.testapp.interfaces.behaviour.BehaviourInterfacesMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.interfaces_behaviour).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BehaviourInterfacesMainActivity.class));
            }
        });

        findViewById(R.id.interfaces_attributes).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AttributeInterfacesMainActivity.class));
            }
        });

        findViewById(R.id.events_behaviour).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), BehaviourEventsMainActivity.class));
            }
        });

        findViewById(R.id.events_attributes).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AttributeEventsMainActivity.class));
            }
        });
    }
}
