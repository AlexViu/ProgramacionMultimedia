package com.example.ejerciciosuma;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText num1 = (EditText) findViewById(R.id.num1);
        final EditText num2 = (EditText) findViewById(R.id.num2);
        final Button boton = (Button) findViewById(R.id.suma);
        final TextView resul = (TextView) findViewById(R.id.resultado);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numero1 = num1.getText().toString();
                Integer num1 = Integer.parseInt(numero1);
                String numero2 = num2.getText().toString();
                Integer num2 = Integer.parseInt(numero2);

                int result = num1 + num2;

                String resulf = "El resultado es: " + result;
                resul.setText(resulf);

            }
        });

    }
}