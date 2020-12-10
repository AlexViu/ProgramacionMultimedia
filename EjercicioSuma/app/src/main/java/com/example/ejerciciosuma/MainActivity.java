package com.example.ejerciciosuma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button add_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        add_fragment = (Button) findViewById(R.id.add_fragment);


        add_fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Paso 1: Obtener la instancia del administrador de fragmentos
                FragmentManager fragmentManager = getSupportFragmentManager();


                //Paso 2: Crear una nueva transacción
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                //Paso 3: Crear un nuevo fragmento y añadirlo
                BlankFragment bfragment = new BlankFragment();
                FragmentTransaction add = fragmentTransaction.add(R.id.container, bfragment);

                fragmentTransaction.commit();
            }
        });

    }
}