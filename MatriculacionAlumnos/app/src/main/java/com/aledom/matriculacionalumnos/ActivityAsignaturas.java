package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Toast;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewModel;
import com.aledom.matriculacionalumnos.data.asignatura.AsiganturaAdapter;
import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;


public class ActivityAsignaturas extends AppCompatActivity {
    private AsignaturaViewModel mViewModel;
    private RecyclerView mList;
    private AsiganturaAdapter mAdapter;
    private String icon_identity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asignaturas);

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
        mAdapter = new AsiganturaAdapter();
        mList.setAdapter(mAdapter);

        mAdapter.setItemListener(new AsiganturaAdapter.ItemListener() {

            @Override
            public void onUpdateIconClicked(AsignaturaForList Asignatura) {
                UpdateAsignatura(Asignatura);
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

    private void UpdateAsignatura(AsignaturaForList Asignatura) {
        Intent intent = new Intent(this, UpdateAsignaturaActivity.class);

        String codigo = String.valueOf(Asignatura.codigo_asignatura);

        intent.putExtra("name", Asignatura.name);
        intent.putExtra("codigo", codigo);
        startActivity(intent);
    }

}