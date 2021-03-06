package com.aledom.matriculacionalumnos.data.asignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaId;
import com.aledom.matriculacionalumnos.data.MatriculacionDatabase;

import java.util.List;

public class AsignaturaRepository {

    private final LiveData<List<AsignaturaForList>> AsignaturaLists;
    private final AsignaturaDao asignaturaDao;

    public AsignaturaRepository(Context context) {
        MatriculacionDatabase db = MatriculacionDatabase.getInstance(context);
        asignaturaDao = db.AsignaturaDao();
        AsignaturaLists = asignaturaDao.getAll();
    }

    //Metodos para ejecutar las querys del DAO
    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return AsignaturaLists;
    }

    public void insert(AsignaturaInsert asignatura) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.insert(asignatura)
        );
    }

    public void actualizar(AsignaturaUpdate asignatura) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.actualizar(asignatura.id, asignatura.codigo_asignatura, asignatura.name)
        );
    }

    public void deleteAsignatura(AsignaturaId id) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.deleteAsignatura(id)
        );
    }

}
