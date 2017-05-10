package com.example.olgacoll.sifu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

/**
 * Created by olgacoll on 4/5/17.
 */

public class ConfigActivity extends AppCompatActivity{

    Switch switch1;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);

        initComponents();
        setupToolbar();
        onPrepareBottomNav();
    }

    private void initComponents(){
        switch1 = (Switch) findViewById(R.id.switch1);
        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
    }

    private void setupToolbar() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        // Hide the title
        getSupportActionBar().setTitle(null);
        // Set onClickListener to customView
        TextView tvSave = (TextView) findViewById(R.id.toolbar_save);
        tvSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.toolbar_save:
                        //initConfig();
                        break;
                }
            }
        });
    }

    private void onPrepareBottomNav() {
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.menu_home:
                        initHome();
                        break;
                    case R.id.menu_report:
                        initReport();
                        break;
                    case R.id.menu_request:
                        initRequest();
                        break;
                    case R.id.menu_info:
                        initInfo();
                        break;
                }
                return true;
            }
        });
    }

    private void initHome(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    private void initReport(){
        Intent intent = new Intent(this, ReportActivity.class);
        startActivity(intent);
    }

    private void initRequest(){
        Intent intent = new Intent(this, RequestActivity.class);
        startActivity(intent);
    }

    private void initInfo(){
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }

    private void initConfig(){
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }
}


/*
// check current state of a Switch (true or false).
Boolean switchState = simpleSwitch.isChecked();

 * */
