package com.aledom.dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements BlankFragment.OnSimpleDialogListener {

    private Button boton1;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button) findViewById(R.id.Boton);
        text = (TextView) findViewById(R.id.texto);

        boton1.setOnClickListener(new boton_listener());
    }

    @Override
    public void onPossitiveButtonClick() {
        text.setText("Has pulsado SI");
    }

    @Override
    public void onNegativeButtonClick() {
        text.setText("Has pulsado NO");
    }

    class boton_listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            new BlankFragment().show(getSupportFragmentManager(), "BlankFragment");
        }
    }


}