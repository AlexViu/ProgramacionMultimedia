package com.aledom.calculadorafragmentestatico;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalculadoraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CalculadoraFragment extends Fragment {

    double num1 = 0;
    double resultado = 0;
    String op = "";
    String sim = "";
    boolean cont_coma = false;
    boolean cont_result = false;
    private TextView operacion;
    private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    private Button boton_clear, boton_div, boton_multi, boton_borrar, boton_resta, boton_suma, boton_igual, boton_coma;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalculadoraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalculadoraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalculadoraFragment newInstance(String param1, String param2) {
        CalculadoraFragment fragment = new CalculadoraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        operacion = (TextView) view.findViewById(R.id.result);

        //Botones numeros

        boton0 = (Button) view.findViewById(R.id.button0);
        boton1 = (Button) view.findViewById(R.id.button1);
        boton2 = (Button) view.findViewById(R.id.button2);
        boton3 = (Button) view.findViewById(R.id.button3);
        boton4 = (Button) view.findViewById(R.id.button4);
        boton5 = (Button) view.findViewById(R.id.button5);
        boton6 = (Button) view.findViewById(R.id.button6);
        boton7 = (Button) view.findViewById(R.id.button7);
        boton8 = (Button) view.findViewById(R.id.button8);
        boton9 = (Button) view.findViewById(R.id.button9);

        //Botones acciones

        boton_clear = (Button) view.findViewById(R.id.buttonC);
        boton_div = (Button) view.findViewById(R.id.buttonDividir);
        boton_multi = (Button) view.findViewById(R.id.buttonMultiplicar);
        boton_borrar = (Button) view.findViewById(R.id.buttonBorrar);
        boton_resta = (Button) view.findViewById(R.id.buttonResta);
        boton_suma = (Button) view.findViewById(R.id.buttonSuma);
        boton_igual = (Button) view.findViewById(R.id.buttonIgual);
        boton_coma = (Button) view.findViewById(R.id.buttonComa);

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

        return view;
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