package com.aledom.calculadorahp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    double num1 = 0;
    double resultado = 0;
    String op = "";
    String sim = "";
    boolean cont_coma = false;
    boolean cont_result = false;
    private TextView operacion;
    private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    private Button boton_clear, boton_div, boton_multi, boton_borrar, boton_resta, boton_suma, boton_igual, boton_coma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        operacion = (TextView) findViewById(R.id.result);

        //Botones numeros
        
        boton0 = (Button) findViewById(R.id.button0);
        boton1 = (Button) findViewById(R.id.button1);
        boton2 = (Button) findViewById(R.id.button2);
        boton3 = (Button) findViewById(R.id.button3);
        boton4 = (Button) findViewById(R.id.button4);
        boton5 = (Button) findViewById(R.id.button5);
        boton6 = (Button) findViewById(R.id.button6);
        boton7 = (Button) findViewById(R.id.button7);
        boton8 = (Button) findViewById(R.id.button8);
        boton9 = (Button) findViewById(R.id.button9);

        //Botones acciones

        boton_clear = (Button) findViewById(R.id.buttonC);
        boton_div = (Button) findViewById(R.id.buttonDividir);
        boton_multi = (Button) findViewById(R.id.buttonMultiplicar);
        boton_borrar = (Button) findViewById(R.id.buttonBorrar);
        boton_resta = (Button) findViewById(R.id.buttonResta);
        boton_suma = (Button) findViewById(R.id.buttonSuma);
        boton_igual = (Button) findViewById(R.id.buttonIgual);
        boton_coma = (Button) findViewById(R.id.buttonComa);

        // listener de los botones

        boton0.setOnClickListener(new boton_listener());
        boton1.setOnClickListener(new boton_listener());
        boton2.setOnClickListener(new boton_listener());
        boton3.setOnClickListener(new boton_listener());
        boton4.setOnClickListener(new boton_listener());
        boton5.setOnClickListener(new boton_listener());
        boton6.setOnClickListener(new boton_listener());
        boton7.setOnClickListener(new boton_listener());
        boton8.setOnClickListener(new boton_listener());
        boton9.setOnClickListener(new boton_listener());

        boton_clear.setOnClickListener(new boton_listener());
        boton_div.setOnClickListener(new boton_listener());
        boton_multi.setOnClickListener(new boton_listener());
        boton_borrar.setOnClickListener(new boton_listener());
        boton_resta.setOnClickListener(new boton_listener());
        boton_suma.setOnClickListener(new boton_listener());
        boton_igual.setOnClickListener(new boton_listener());
        boton_coma.setOnClickListener(new boton_listener());

    }

    class boton_listener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (cont_result == false) {

                //Botones numeros
                if (v == boton0) {
                    op = op + "0";
                    operacion.setText(op);
                }
                if (v == boton1) {
                    op = op + "1";
                    operacion.setText(op);
                }
                if (v == boton2) {
                    op = op + "2";
                    operacion.setText(op);
                }
                if (v == boton3) {
                    op = op + "3";
                    operacion.setText(op);
                }
                if (v == boton4) {
                    op = op + "4";
                    operacion.setText(op);
                }
                if (v == boton5) {
                    op = op + "5";
                    operacion.setText(op);
                }
                if (v == boton6) {
                    op = op + "6";
                    operacion.setText(op);
                }
                if (v == boton7) {
                    op = op + "7";
                    operacion.setText(op);
                }
                if (v == boton8) {
                    op = op + "8";
                    operacion.setText(op);
                }
                if (v == boton9) {
                    op = op + "9";
                    operacion.setText(op);
                }
                if (v == boton_coma) {
                    if (cont_coma == false) {
                        op = op + ".";
                        operacion.setText(op);
                        cont_coma = true;
                    }
                }

                //Botones operaciones
                if (v == boton_div) {
                    num1 = Double.parseDouble(op);
                    sim = "/";
                    operacion.setText("");
                    op = "";
                }
                if (v == boton_multi) {
                    num1 = Double.parseDouble(op);
                    sim = "*";
                    operacion.setText("");
                    op = "";
                }
                if (v == boton_suma) {
                    num1 = Double.parseDouble(op);
                    sim = "+";
                    operacion.setText("");
                    op = "";
                }
                if (v == boton_resta) {
                    num1 = Double.parseDouble(op);
                    sim = "-";
                    operacion.setText("");
                    op = "";
                }
                if (v == boton_borrar) {
                    if (op.length() > 0) {
                        op = op.substring(0, op.length() - 1);
                        operacion.setText(op);
                    }
                }
                if (v == boton_igual) {
                    switch (sim) {
                        case "+":
                            resultado = num1 + Double.parseDouble(op);
                            operacion.setText(Double.toString(resultado));
                            break;
                        case "-":
                            resultado = num1 - Double.parseDouble(op);
                            operacion.setText(Double.toString(resultado));
                            break;
                        case "*":
                            resultado = num1 * Double.parseDouble(op);
                            operacion.setText(Double.toString(resultado));
                            break;
                        case "/":
                            resultado = num1 / Double.parseDouble(op);
                            operacion.setText(Double.toString(resultado));
                            break;
                    }
                    cont_result = true;
                }
            }
            // Boton volver a empezar
            if (v == boton_clear) {
                num1 = 0;
                op = "";
                sim = "";
                cont_coma = false;
                cont_result = false;
                operacion.setText("");
            }
        }
    }
}