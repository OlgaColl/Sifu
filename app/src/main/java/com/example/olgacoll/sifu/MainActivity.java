package com.example.olgacoll.sifu;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewInfo;
    Button buttonReport, buttonRequest;
    View.OnClickListener listener;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        onPrepareListener();
        setupToolbar();
        onPrepareBottomNav();
        buttonReport.setOnClickListener(listener);
        buttonRequest.setOnClickListener(listener);
    }

    private void initComponents(){
        textViewInfo = (TextView)findViewById(R.id.textViewMain);
        buttonReport = (Button)findViewById(R.id.buttonReport);
        buttonRequest = (Button)findViewById(R.id.buttonRequest);
        bottomNav = (BottomNavigationView)findViewById(R.id.navigation);
    }

    private void onPrepareListener(){
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch(v.getId()){
                    case R.id.buttonReport:
                        initReport();
                        break;
                    case R.id.buttonRequest:
                        initRequest();
                        break;
                }
            }
        };
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
                    case R.id.toolbar:
                        initConfig();
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
                        //initHome();
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
        Intent intent = new Intent(this, ReportActivity.class);
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