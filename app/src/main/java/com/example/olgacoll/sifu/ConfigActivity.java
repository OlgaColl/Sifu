package com.example.olgacoll.sifu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Switch;

/**
 * Created by olgacoll on 4/5/17.
 */

public class ConfigActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }
}


/*
 *  // initiate a Switch
Switch simpleSwitch = (Switch) findViewById(R.id.simpleSwitch);

// check current state of a Switch (true or false).
Boolean switchState = simpleSwitch.isChecked();

 * */
