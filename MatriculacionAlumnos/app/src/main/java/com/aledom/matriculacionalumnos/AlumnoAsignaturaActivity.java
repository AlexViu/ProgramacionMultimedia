package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewModel;
import com.aledom.matriculacionalumnos.data.alumnos_asignatura.AlumnoAsignaturaAdapter;
import com.aledom.matriculacionalumnos.data.asignatura.AsiganturaAdapter;

public class AlumnoAsignaturaActivity extends AppCompatActivity {

    private AsignaturaViewModel mViewModel;
    private RecyclerView mList;
    private AlumnoAsignaturaAdapter mAdapter;
    private String icon_identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_asignatura);

        getSupportActionBar().setTitle("Asignaturas");

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        setupList();

        setupFab();


    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AlumnoAsignaturaAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AlumnoAsignaturaAdapter.ItemListener() {


            @Override
            public void onDeleteIconClicked(AsignaturaForList Asignatura) {

            }
        });

        mViewModel.getAllAsignaturas().observe(this, mAdapter::setItems);


    }

    private void setupFab() {
        //findViewById(R.id.floating_action_button).setOnClickListener(view -> addNewAsignatura());
    }

    private void addNewAsignatura() {
        String campo_id = getIntent().getStringExtra("id");
        //startActivity(new Intent(this, AddAsignaturaActivity.class));
    }

}