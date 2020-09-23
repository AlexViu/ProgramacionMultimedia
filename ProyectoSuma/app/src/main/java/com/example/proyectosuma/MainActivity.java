package com.example.proyectosuma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto1 = (EditText) findViewById(R.id.miTxt1);
        final EditText miTexto2 = (EditText) findViewById(R.id.miTxt2);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        final TextView resultado = (TextView) findViewById(R.id.miLbl);

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero1 = miTexto1.getText().toString();
                Integer num1 = Integer.parseInt(numero1);
                String numero2 = miTexto2.getText().toString();
                Integer num2 = Integer.parseInt(numero2);

                int resultadof = num1+num2;
                String resfinal = "La suma es: " + resultadof;
                resultado.setText(resfinal.toUpperCase());

            }
        });

    }
}