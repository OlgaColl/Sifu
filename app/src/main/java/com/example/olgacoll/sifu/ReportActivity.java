package com.example.olgacoll.sifu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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
    Bundle bundle;
    Button buttonEnviar;
    View.OnClickListener listener;
    AdapterView.OnItemSelectedListener listenerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        initComponents();
        onPrepareListener();
        setupToolbar();
        //onPrepareBottomNav();
        controlSpinner();

        buttonEnviar.setOnClickListener(listener);
    }

    public void initComponents(){
        editTextNombre = (EditText)findViewById(R.id.input_nombre);
        editTextApellidos = (EditText)findViewById(R.id.input_apellidos);
        editTextEmail = (EditText)findViewById(R.id.input_email);
        editTextTelefono = (EditText)findViewById(R.id.input_telefono);
        editTextCliente = (EditText)findViewById(R.id.input_cliente);
        editTextComentarios = (EditText)findViewById(R.id.input_comentarios);
        buttonEnviar = (Button)findViewById(R.id.buttonEnviar);
    }

    public void onPrepareListener() {
        listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.buttonEnviar:
                        initSend();
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

    private void setBundle(){
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
    }

    public void initSend(){
        setBundle();
        Toast.makeText(getApplicationContext(), "OK incidencia", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private void initConfig(){
        Intent intent = new Intent(this, ConfigActivity.class);
        startActivity(intent);
    }
}
