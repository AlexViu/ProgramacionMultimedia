package com.aledom.perrito;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public final static int OPINION_REQUEST_CODE = 1;
    public final static String EXTRA_NOMBRE = "TUPAQUETE.petmotion.NOMBRE";

    /**
     * Fijamos el layout, obtenemos el boton de la vista y definimos su funcionalidad
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButton = (Button) findViewById(R.id.mostrar_perrito);
        TextView autores = (TextView) findViewById(R.id.autores);


        myButton.setOnClickListener(new View.OnClickListener() {
            /**
             * El metodo onClick crea un intent y con el putextra le pasamos el string al visor
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent miIntent = new Intent(MainActivity.this, visor.class);
                miIntent.putExtra(EXTRA_NOMBRE, "pet1.jpg");
                startActivityForResult(miIntent,OPINION_REQUEST_CODE);
            }
        });

        autores.setOnClickListener(new View.OnClickListener() {
            /**
             * Al hacer click en el TextView de autores creamos un intent que nos dirige a una pagina web
             * @param v
             */
            @Override
            public void onClick(View v) {
                Uri webpage = Uri.parse("https://github.com/AlexViu");
                Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);
                startActivity(webIntent);
            }
        });
    }

    /**
     * Recogemos el resultado del radioGroup de la clase visor, y mostramos en el testView EL resultado
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView results = (TextView) findViewById(R.id.result);

        if (requestCode == OPINION_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                String result=data.getStringExtra("opinion");
                results.setText("Tu opinion fué "+ result);
            }
        }
    }
}