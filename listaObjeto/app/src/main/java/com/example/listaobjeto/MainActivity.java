package com.example.listaobjeto;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Titular[] datos = new Titular[]{
            new Titular("Titilo 1", "Subtitulo largo 1", R.drawable.ic_launcher_background),
            new Titular("Titilo 2", "Subtitulo largo 2", R.drawable.ic_launcher_background),
            new Titular("Titilo 3", "Subtitulo largo 3", R.drawable.ic_launcher_background),
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdaptadorTitulares adaptador = new AdaptadorTitulares(this);
        ListView lstOpciones = (ListView)findViewById(R.id.LstOpciones);
        lstOpciones.setAdapter(adaptador);

        lstOpciones.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String mensaje = "Titulo: " + datos[position].getTitulo() + " . Subtitulo: " + datos[position].getSubtitulo();
                Toast.makeText(getApplicationContext(),mensaje, Toast.LENGTH_SHORT).show();
            }
        });
    }
    class AdaptadorTitulares extends ArrayAdapter {

        Activity context;

        AdaptadorTitulares(Activity context) {
            super(context, R.layout.lista_layout, datos);
            this.context = context;
        }

        public View getView(int i, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.lista_layout, null);

            TextView lblTitulo = (TextView) item.findViewById(R.id.tvTitulo);
            lblTitulo.setText(datos[i].getTitulo());

            TextView lblSubtitulo = (TextView) item.findViewById(R.id.tvSubtitulo);
            lblSubtitulo.setText(datos[i].getSubtitulo());

            ImageView imagen = (ImageView) item.findViewById(R.id.ivImagen);
            imagen.setBackground(getDrawable(datos[i].getImagen()));

            return (item);
        }

    }
}