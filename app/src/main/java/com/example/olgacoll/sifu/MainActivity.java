package com.example.olgacoll.sifu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewInfo, textViewInfo2;
    Button buttonReport, buttonRequest;
    View.OnClickListener listener;
    BottomNavigationView bottomNav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        onPrepareListener();
        onPrepareBottomNav();

        buttonReport.setOnClickListener(listener);
        buttonRequest.setOnClickListener(listener);
    }

    private void initComponents(){
        textViewInfo = (TextView)findViewById(R.id.textViewMain);
        textViewInfo2 = (TextView)findViewById(R.id.textViewMain2);
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
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
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
}