package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;

import com.aledom.matriculacionalumnos.alumnos.AlumnoViewModel;

import com.aledom.matriculacionalumnos.data.alumnos.AlumnoInsert;


import java.util.UUID;

public class AddAlumnoActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_alumno);

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
            AlumnoViewModel vm = new ViewModelProvider(this, factory).get(AlumnoViewModel.class);

            setupCreateButton(vm);
        }

        private void setupCreateButton(AlumnoViewModel vm) {
            findViewById(R.id.create_button_alum).setOnClickListener(
                    view -> {
                        // Obtener valor del campo de texto
                        EditText nameField = findViewById(R.id.name_alumno);
                        EditText apellidoField = findViewById(R.id.apellido_alumno);
                        EditText dniField = findViewById(R.id.dni_alumno);

                        String name = nameField.getText().toString();
                        String apellido = apellidoField.getText().toString();
                        String dni = dniField.getText().toString();

                        // Ignorar acción si hay 0 caracteres
                        if (name.isEmpty()) {
                            return;
                        }

                        // Crear entidad y guardarla
                        String id = UUID.randomUUID().toString();
                        AlumnoInsert alumno = new AlumnoInsert(name, apellido, dni);
                        vm.insert(alumno);

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
