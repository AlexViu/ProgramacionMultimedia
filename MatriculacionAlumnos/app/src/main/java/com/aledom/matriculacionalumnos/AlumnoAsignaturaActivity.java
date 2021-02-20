package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aledom.matriculacionalumnos.alumnos_asignaturas.AlumnosAsignaturasForList;
import com.aledom.matriculacionalumnos.alumnos_asignaturas.AlumnosAsignaturasViewModel;

import com.aledom.matriculacionalumnos.data.alumnos_asignatura.AlumnoAsignaturaAdapter;


public class AlumnoAsignaturaActivity extends AppCompatActivity {

    private AlumnosAsignaturasViewModel mViewModel;
    private RecyclerView mList;
    private AlumnoAsignaturaAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_asignatura);

        getSupportActionBar().setTitle("Asignaturas");

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AlumnosAsignaturasViewModel.class);

        setupList();

        setupFab();


    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AlumnoAsignaturaAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AlumnoAsignaturaAdapter.ItemListener() {

            @Override
            public void onDeleteIconClicked(AlumnosAsignaturasForList Asignatura) {

            }

        });

       // mViewModel.getAllAlumnosAsignaturas().observe(this, mAdapter::setItems);

    }

    private void setupFab() {
        findViewById(R.id.floating_action_button).setOnClickListener(view -> addNewAsignatura());
    }

    private void addNewAsignatura() {
        startActivity(new Intent(this, AddAlumnoAsignatura.class));
    }

}