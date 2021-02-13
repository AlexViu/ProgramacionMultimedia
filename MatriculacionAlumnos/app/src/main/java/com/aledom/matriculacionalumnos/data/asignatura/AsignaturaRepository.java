package com.aledom.matriculacionalumnos.data.asignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.data.MatriculacionDatabase;

import java.util.List;

public class AsignaturaRepository {

    private final LiveData<List<Asignatura>> AsignaturaLists;
    private final AsignaturaDao asignaturaDao;

    public AsignaturaRepository(Context context) {
        MatriculacionDatabase db = MatriculacionDatabase.getInstance(context);
        asignaturaDao = db.AsignaturaDao();
        AsignaturaLists = asignaturaDao.getAll();
    }
    //para obtener lista asignaturas de db
    public LiveData<List<Asignatura>> getAllAsignaturas() {
        return AsignaturaLists;
    }
    //para insertar asignatura a db
    public void insert(AsignaturaInsert asignatura) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.insert(asignatura)
        );
    }
    //para actualizar info de asignatura en bd
    public void updateAsignatura(Asignatura Asignatura) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.updateAsignatura(Asignatura)
        );
    }

}
