package com.example.olgacoll.sifu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by olgacoll on 4/5/17.
 */

public class ReportActivity extends AppCompatActivity{

    EditText editTextNombre, editTextApellidos, editTextEmail, editTextTelefono, editTextCliente, editTextComentarios;
    Spinner spinner;
    String dadesSpinner[];
    String provincia;
    BottomNavigationView bottomNav;
    Bundle bundle;
    int indexButton;
    Button buttonSubirImagen, buttonEnviar;
    Button buttonEscogeImagen, buttonEscogeImagen2, buttonEscogeImagen3, buttonEscogeImagen4;
    Button buttonBorrarImagen2, buttonBorrarImagen3, buttonBorrarImagen4;
    View.OnClickListener listener;
    AdapterView.OnItemSelectedListener listenerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        initComponents();
        onPrepareListener();
        setupToolbar();
        onPrepareBottomNav();
        controlSpinner();

        buttonSubirImagen.setOnClickListener(listener);
        buttonEscogeImagen.setOnClickListener(listener);
        buttonEscogeImagen2.setOnClickListener(listener);
        buttonEscogeImagen3.setOnClickListener(listener);
        buttonEscogeImagen4.setOnClickListener(listener);
        buttonBorrarImagen2.setOnClickListener(listener);
        buttonBorrarImagen3.setOnClickListener(listener);
        buttonBorrarImagen4.setOnClickListener(listener);
        buttonEnviar.setOnClickListener(listener);
    }

    public void initComponents(){
        editTextNombre = (EditText)findViewById(R.id.input_nombre);
        editTextApellidos = (EditText)findViewById(R.id.input_apellidos);
        editTextEmail = (EditText)findViewById(R.id.input_email);
        editTextTelefono = (EditText)findViewById(R.id.input_telefono);
        editTextCliente = (EditText)findViewById(R.id.input_cliente);
        editTextComentarios = (EditText)findViewById(R.id.input_comentarios);
        buttonSubirImagen = (Button)findViewById(R.id.buttonSubirImagen);
        buttonEscogeImagen = (Button)findViewById(R.id.buttonEscogeImagen);
        buttonEscogeImagen2 = (Button)findViewById(R.id.buttonEscogeImagen2);
        buttonEscogeImagen3 = (Button)findViewById(R.id.buttonEscogeImagen3);
        buttonEscogeImagen4 = (Button)findViewById(R.id.buttonEscogeImagen4);
        buttonBorrarImagen2 = (Button)findViewById(R.id.buttonBorrarImagen2);
        buttonBorrarImagen3 = (Button)findViewById(R.id.buttonBorrarImagen3);
        buttonBorrarImagen4 = (Button)findViewById(R.id.buttonBorrarImagen4);
        buttonEnviar = (Button)findViewById(R.id.buttonEnviar);
        bottomNav = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        indexButton = 1; //Con este índice, controlaremos las veces que hayan dado clic en Subir Imagen.
    }

    public void onPrepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonEnviar:
                        initSend();
                        break;
                    case R.id.buttonSubirImagen:
                        if(indexButton <= 4) indexButton++; //control para que nunca pase de 4.
                        initSubirImagen(indexButton);
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
                    case R.id.toolbar_save:
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
                        initHome();
                        break;
                    case R.id.menu_report:
                        //initReport();
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

    public void controlSpinner(){
        spinner = (Spinner)findViewById(R.id.spinner);
        dadesSpinner =  new String[]{"Barcelona", "Madrid", "Valencia"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, dadesSpinner);
        spinner.setAdapter(adaptador);
        prepareItemListener();
        spinner.setOnItemSelectedListener(listenerSpinner);
    }

    public void prepareItemListener() {
        listenerSpinner =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        switch (dadesSpinner[position]) {
                            case "Barcelona":
                                provincia = "Barcelona";
                                showMessage();
                                break;
                            case "Madrid":
                                provincia = "Madrid";
                                showMessage();
                                break;
                            case "Valencia":
                                provincia = "Valencia";
                                showMessage();
                                break;
                        }
                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                };
    }

    private void showMessage() {
        Toast.makeText(getApplicationContext(), "Provincia seleccionada: " + provincia, Toast.LENGTH_SHORT).show();
    }

    /*private void setBundle(){
        bundle = this.getIntent().getExtras();
        bundle.remove("nombreReport");
        bundle.putString("nombreReport", String.valueOf(editTextNombre.getText()));
        bundle.remove("apellidosReport");
        bundle.putString("apellidosReport", String.valueOf(editTextApellidos.getText()));
        bundle.remove("emailReport");
        bundle.putString("emailReport", String.valueOf(editTextEmail.getText()));
        bundle.remove("telefonoReport");
        bundle.putString("telefonoReport", String.valueOf(editTextTelefono.getText()));
        bundle.remove("provinciaReport");
        bundle.putString("provinciaReport", String.valueOf(provincia));
        bundle.remove("clienteReport");
        bundle.putString("clienteReport", String.valueOf(editTextCliente.getText()));
        bundle.remove("comentariosReport");
        bundle.putString("comentariosReport", String.valueOf(editTextComentarios.getText()));
    }*/

    public void initSend(){
        //setBundle();
        Toast.makeText(getApplicationContext(), "OK incidencia", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void initSubirImagen(int indexButton){
        switch(indexButton){
            case 2:
                buttonEscogeImagen2.setVisibility(View.VISIBLE);
                buttonBorrarImagen2.setVisibility(View.VISIBLE);
                break;
            case 3:
                buttonEscogeImagen3.setVisibility(View.VISIBLE);
                buttonBorrarImagen3.setVisibility(View.VISIBLE);
            case 4:
                buttonEscogeImagen4.setVisibility(View.VISIBLE);
                buttonBorrarImagen4.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void initConfig(){
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }
}
