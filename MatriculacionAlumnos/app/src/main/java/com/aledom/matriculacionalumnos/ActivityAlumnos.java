package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aledom.matriculacionalumnos.alumnos.AlumnoViewModel;
import com.aledom.matriculacionalumnos.alumnos.AlumnosForList;
import com.aledom.matriculacionalumnos.data.alumnos.AlumnoAdapter;

public class ActivityAlumnos extends AppCompatActivity {

    private AlumnoViewModel mViewModel;
    private RecyclerView mList;
    private AlumnoAdapter mAdapter;
    private String icon_identity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        getSupportActionBar().setTitle("Asignaturas");

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AlumnoViewModel.class);

        setupList();

        setupFab();


    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AlumnoAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AlumnoAdapter.ItemListener() {

            @Override
            public void onUpdateIconClicked(AlumnosForList Asignatura) {

            }

            @Override
            public void onDeleteIconClicked(AlumnosForList Alumno) {
                int id = Alumno.id;
                mViewModel.deleteAlumno(Alumno);
            }


        });

        mViewModel.getAllAlumnos().observe(this, mAdapter::setItems);


    }

    private void setupFab() {
        findViewById(R.id.floating_action_button).setOnClickListener(view -> addNewAlumno());
    }

    private void addNewAlumno() {
        startActivity(new Intent(this, AddAlumnoActivity.class));
    }

}