package com.aledom.matriculacionalumnos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewModel;
import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaInsert;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaUpdate;

import java.util.UUID;

public class UpdateAsignaturaActivity extends AppCompatActivity {
    EditText nameField, asignatura_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_asignatura);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ViewModelProvider.AndroidViewModelFactory factory = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication());
        AsignaturaViewModel vm = new ViewModelProvider(this, factory).get(AsignaturaViewModel.class);

        setupCreateButton(vm);

        //Recogemos datos y añadimos la informacion a los edittext
        nameField = (EditText)findViewById(R.id.name_field);
        asignatura_code = (EditText)findViewById(R.id.codigo_asignatura);

        String campo_name = getIntent().getStringExtra("name");
        String campo_code = getIntent().getStringExtra("codigo");

        asignatura_code.setText(campo_code);
        nameField.setText(campo_name);

    }

    private void setupCreateButton(AsignaturaViewModel vm) {
        findViewById(R.id.update_button).setOnClickListener(
                view -> {
                    //Recogemos id del objeto

                    String name = nameField.getText().toString();
                    String code = asignatura_code.getText().toString();
                    int codigo = Integer.parseInt(code);
                    String campo_id = getIntent().getStringExtra("id");
                    int id = Integer.parseInt(campo_id);

                    // Ignorar acción si hay 0 caracteres
                    if (name.isEmpty()) {
                        return;
                    }

                    // Crear entidad y guardarla
                    AsignaturaUpdate asignatura = new AsignaturaUpdate(id, codigo, name);
                    vm.updateAsignatura(asignatura);

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