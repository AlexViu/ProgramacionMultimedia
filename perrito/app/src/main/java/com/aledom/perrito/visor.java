package com.aledom.perrito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class visor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visor);

        TextView nombre_imagen = (TextView)findViewById(R.id.nombre_imagen);
        Button button_send = (Button) findViewById(R.id.send_button);
        final RadioGroup opinions = (RadioGroup) findViewById(R.id.opinions);

        /**
         * Cogemos el string del mainActivity y lo mostramos en el textView
         */
        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.EXTRA_NOMBRE);
        nombre_imagen.setText(name);

        /**
         * Cuando hacemos click en el boton send, coge la informacion del radioGroup y la envia al main
         */
        button_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton currentRadio = (RadioButton) findViewById(opinions.getCheckedRadioButtonId());
                String opinion = currentRadio.getText().toString();
                Intent databack = new Intent();
                databack.putExtra("opinion",opinion);
                setResult(RESULT_OK,databack);
                finish();
            }
        });
    }
}