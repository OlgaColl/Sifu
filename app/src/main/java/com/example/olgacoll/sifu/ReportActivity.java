package com.example.olgacoll.sifu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by olgacoll on 4/5/17.
 */

public class ReportActivity extends AppCompatActivity{

    EditText editTextNombre, editTextApellidos, editTextEmail, editTextTelefono, editTextCliente, editTextComentarios;
    Spinner spinnerProvincia;
    Button buttonEnviar;
    View.OnClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        initComponents();
        onPrepareListener();
        //onPrepareBottomNav();

        buttonEnviar.setOnClickListener(listener);
    }

    public void initComponents(){
        editTextNombre = (EditText)findViewById(R.id.input_nombre);
        editTextApellidos = (EditText)findViewById(R.id.input_apellidos);
        editTextTelefono = (EditText)findViewById(R.id.input_telefono);
        editTextCliente = (EditText)findViewById(R.id.input_cliente);
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

    public void initSend(){
        //TODO Toast? go Main Activity
    }
}
