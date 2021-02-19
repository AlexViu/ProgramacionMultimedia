package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewModel;
import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaInsert;

import java.util.UUID;

public class AddAsignaturaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_asignatura);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        AsignaturaViewModel vm = new ViewModelProvider(this, factory).get(AsignaturaViewModel.class);

        setupCreateButton(vm);
    }

    private void setupCreateButton(AsignaturaViewModel vm) {
        findViewById(R.id.create_button).setOnClickListener(
                view -> {
                    // Obtener valor del campo de texto
                    EditText nameField = findViewById(R.id.name_field);
                    EditText asignatura_code = findViewById(R.id.codigo_asignatura);
                    String name = nameField.getText().toString();
                    String code = asignatura_code.getText().toString();
                    int codigo = Integer.parseInt(code);

                    // Ignorar acción si hay 0 caracteres
                    if (name.isEmpty()) {
                        return;
                    }

                    // Crear entidad y guardarla
                    String id = UUID.randomUUID().toString();
                    AsignaturaInsert asignatura = new AsignaturaInsert(codigo, name);
                    vm.insert(asignatura);

                    // Ir a la lista
                    finish();
                });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }
}