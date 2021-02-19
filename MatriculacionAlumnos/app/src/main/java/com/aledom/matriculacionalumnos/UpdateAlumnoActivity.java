package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;

import com.aledom.matriculacionalumnos.R;
import com.aledom.matriculacionalumnos.alumnos.AlumnoViewModel;
import com.aledom.matriculacionalumnos.data.alumnos.AlumnoInsert;
import com.aledom.matriculacionalumnos.data.alumnos.AlumnoUpdate;

import java.util.UUID;

public class UpdateAlumnoActivity extends AppCompatActivity {
    EditText nameField, apellidoField, dniField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_alumno);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        AlumnoViewModel vm = new ViewModelProvider(this, factory).get(AlumnoViewModel.class);

        setupCreateButton(vm);

        nameField = findViewById(R.id.name_alumno);
        apellidoField = findViewById(R.id.apellido_alumno);
        dniField = findViewById(R.id.dni_alumno);

        String campo_name = getIntent().getStringExtra("name");
        String campo_apellidos = getIntent().getStringExtra("apellidos");
        String campo_dni = getIntent().getStringExtra("dni");

        nameField.setText(campo_name);
        apellidoField.setText(campo_apellidos);
        dniField.setText(campo_dni);

        dniField.setEnabled(false);
    }

    private void setupCreateButton(AlumnoViewModel vm) {
        findViewById(R.id.create_button_alum).setOnClickListener(
                view -> {
                    // Obtener valor del campo de texto

                    String name = nameField.getText().toString();
                    String apellido = apellidoField.getText().toString();
                    String dni = dniField.getText().toString();

                    // Ignorar acción si hay 0 caracteres
                    if (name.isEmpty()) {
                        return;
                    }

                    // Crear entidad y guardarla
                    AlumnoUpdate alumno = new AlumnoUpdate(name, apellido, dni);
                    vm.updateAlumno(alumno);

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