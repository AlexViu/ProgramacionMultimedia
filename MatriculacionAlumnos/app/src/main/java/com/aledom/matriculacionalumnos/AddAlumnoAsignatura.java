package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewModel;
import com.aledom.matriculacionalumnos.data.asignatura.AsiganturaAdapter;

public class AddAlumnoAsignatura extends AppCompatActivity {

    private AsignaturaViewModel mViewModel;
    private RecyclerView mList;
    private AsiganturaAdapter mAdapter;
    private String icon_identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_alumno_asignatura);

        getSupportActionBar().setTitle("Asignaturas");

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        setupList();

    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AsiganturaAdapter();
        mList.setAdapter(mAdapter);

        mViewModel.getAllAsignaturas().observe(this, mAdapter::setItems);


    }


}