package com.nerdscorner.mvplib.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;

import com.nerdscorner.mvplib.testapp.events.EventsMainActivity;
import com.nerdscorner.mvplib.testapp.interfaces.InterfacesMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        findViewById(R.id.interfaces).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), InterfacesMainActivity.class));
            }
        });

        findViewById(R.id.events).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EventsMainActivity.class));
            }
        });
    }
}
