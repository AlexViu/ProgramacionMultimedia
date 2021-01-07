package com.aledom.calculadorafragmentdinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button boton_cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        boton_cal = (Button) findViewById(R.id.boton_mostrar);
        boton_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Crear una nueva transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Crear un nuevo fragmento y añadirlo
                CalculadoraFragment cfragment = new CalculadoraFragment();
                FragmentTransaction add = fragmentTransaction.add(R.id.container, cfragment);

                fragmentTransaction.commit();
            }
        });
    }
}