package com.example.a2pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Estoy en la pantalla1",Toast.LENGTH_LONG).show();
        ImageButton miBoton = (ImageButton) findViewById(R.id.miBtn);


        miBoton.setOnClickListener(new View.OnClickListener() {
        @Override
            public void onClick(View v) {
            showToast("Estoy en pantalla");
            }
        });
    }

protected void onStart() {
        super.onStart();
        Toast.makeText(this, "A1:onStart", Toast.LENGTH_SHORT).show();
}

protected void onResume() {
        super.onResume();
    Toast.makeText(this, "A1:onResume", Toast.LENGTH_SHORT).show();
}



    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}