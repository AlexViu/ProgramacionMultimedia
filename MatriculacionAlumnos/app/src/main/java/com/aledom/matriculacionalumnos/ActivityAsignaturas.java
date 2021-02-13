package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewModel;
import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;


public class ActivityAsignaturas extends AppCompatActivity {

    private AsignaturaViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        TextView dbText = findViewById(R.id.list);

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        mViewModel.getAllAsignaturas().observe(this, asignaturas -> {
                    StringBuilder sb = new StringBuilder();
                    for (Asignatura list : asignaturas) {
                        sb.append(list.getName()).append("\n");
                    }
                    dbText.setText(sb.toString());
                }
        );
    }
}