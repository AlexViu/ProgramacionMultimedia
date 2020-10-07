package com.example.proyectosuma;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        final TextView resFinal = (TextView)findViewById(R.id.resFin);
        final Button volverBtn = (Button)findViewById(R.id.BtnVolver);

        Bundle miBundleRecoger = getIntent().getExtras();
        resFinal.setText(miBundleRecoger.getString("TEXTO"));

        final String respuesta= miBundleRecoger.getString("TEXTO");

        volverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent volverIntent = new Intent();
                Bundle volverBundle = new Bundle();
                String volverMsj= "Devuelvo a Principal: " + respuesta;
                volverBundle.putString("VOLVER", volverMsj);
                volverIntent.putExtras(volverBundle);
                setResult(RESULT_OK, volverIntent);
                finish();
            }
        });
    }
}