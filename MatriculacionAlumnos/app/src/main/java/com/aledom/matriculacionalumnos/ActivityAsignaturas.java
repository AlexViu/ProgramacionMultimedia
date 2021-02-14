package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewModel;
import com.aledom.matriculacionalumnos.data.asignatura.AsiganturaAdapter;


public class ActivityAsignaturas extends AppCompatActivity {
    private AsignaturaViewModel mViewModel;
    private RecyclerView mList;
    private AsiganturaAdapter mAdapter;
    private String icon_identity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

        getSupportActionBar().setTitle("Alumnos");

        ViewModelProvider.AndroidViewModelFactory factory =
                ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());

        mViewModel = new ViewModelProvider(this, factory)
                .get(AsignaturaViewModel.class);

        setupList();

        setupFab();


    }

    private void setupList() {
        mList = findViewById(R.id.list);
        mAdapter = new AsiganturaAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AsiganturaAdapter.ItemListener() {

            @Override
            public void onUpdateIconClicked(AsignaturaForList Asignatura) {
                //Funcion Actualizar
            }

            @Override
            public void onDeleteIconClicked(AsignaturaForList Asignatura) {
                int id = Asignatura.id;
                mViewModel.deleteAsignatura(Asignatura);
            }
        });

        mViewModel.getAllAsignaturas().observe(this, mAdapter::setItems);


    }

    private void setupFab() {
        findViewById(R.id.floating_action_button).setOnClickListener(view -> addNewAsignatura());
    }

    private void addNewAsignatura() {
        startActivity(new Intent(this, AddAsignaturaActivity.class));
    }


}