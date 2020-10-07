package com.example.proyectosuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static int COD_RESPUESTA=0;
    TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText miTexto1 = (EditText) findViewById(R.id.miTxt1);
        final EditText miTexto2 = (EditText) findViewById(R.id.miTxt2);
        final Button miBoton = (Button) findViewById(R.id.miBtn);
        resultado = (TextView) findViewById(R.id.miLbl);

        if (savedInstanceState!=null) {
            String mensajePasado=savedInstanceState.getString("TEXTO");
            resultado.setText(mensajePasado);
        }

        miBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent miIntent = new Intent(MainActivity.this, pantalla2.class);
                Bundle miBundle= new Bundle();

                String numero1 = miTexto1.getText().toString();
                Integer num1 = Integer.parseInt(numero1);
                String numero2 = miTexto2.getText().toString();
                Integer num2 = Integer.parseInt(numero2);

                int resultadof = num1+num2;
                String resfinal = "La suma es: " + resultadof;
                //resultado.setText(resfinal.toUpperCase());
                miBundle.putString("TEXTO", resfinal);
                miIntent.putExtras(miBundle);
                startActivityForResult(miIntent, COD_RESPUESTA);


            }
        });
    }

    public void onActivityResult(int cod_resp, int cod_result, Intent intent) {
        super.onActivityResult(cod_resp, cod_result, intent);
        if (cod_result == RESULT_OK) {
            Bundle otroBundle = intent.getExtras();
            resultado.setText(otroBundle.getString("VOLVER"));
        }
    }
}