package com.example.olgacoll.sifu;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by olgacoll on 4/5/17.
 */

public class RequestActivity extends AppCompatActivity{

    EditText editTextNombre, editTextApellidos, editTextEmail, editTextTelefono, editTextComentarios;
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
        setContentView(R.layout.activity_request);

        initComponents();
        onPrepareListener();
        //onPrepareBottomNav();
        controlSpinner();

        buttonEnviar.setOnClickListener(listener);
    }

    public void initComponents(){
        editTextNombre = (EditText)findViewById(R.id.input_nombre);
        editTextApellidos = (EditText)findViewById(R.id.input_apellidos);
        editTextEmail = (EditText)findViewById(R.id.input_email);
        editTextTelefono = (EditText)findViewById(R.id.input_telefono);
        editTextComentarios = (EditText)findViewById(R.id.input_comentarios);

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
        bundle.remove("nombreRequest");
        bundle.putString("nombreRequest", String.valueOf(editTextNombre.getText()));
        bundle.remove("apellidosRequest");
        bundle.putString("apellidosRequest", String.valueOf(editTextApellidos.getText()));
        bundle.remove("emailRequest");
        bundle.putString("emailRequest", String.valueOf(editTextEmail.getText()));
        bundle.remove("telefonoRequest");
        bundle.putString("telefonoRequest", String.valueOf(editTextTelefono.getText()));
        bundle.remove("provinciaRequest");
        bundle.putString("provinciaRequest", String.valueOf(provincia));
        bundle.remove("comentariosRequest");
        bundle.putString("comentariosRequest", String.valueOf(editTextComentarios.getText()));
    }

    public void initSend(){
        setBundle();
        Toast.makeText(getApplicationContext(), "OK incidencia", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
