package com.example.a2pantallas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
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
                Intent miIntent = new Intent(MainActivity.this, MainActivity2.class);

                startActivity(miIntent);
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

    protected  void onPause() {
        Toast.makeText(this, "A1:onPause", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    protected void  onStop() {
        super.onStop();
        Toast.makeText(this, "A1:onStop", Toast.LENGTH_SHORT).show();
    }

    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "A1:onRestart", Toast.LENGTH_SHORT).show();
    }

    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    protected void showToast(CharSequence text) {
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }
}