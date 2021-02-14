package com.aledom.matriculacionalumnos.data.asignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaId;
import com.aledom.matriculacionalumnos.data.MatriculacionDatabase;

import java.util.List;

public class AsignaturaRepository {

    //variables
    private final LiveData<List<AsignaturaForList>> AsignaturaLists;
    private final AsignaturaDao asignaturaDao;

    public AsignaturaRepository(Context context) {
        MatriculacionDatabase db = MatriculacionDatabase.getInstance(context);
        asignaturaDao = db.AsignaturaDao();
        AsignaturaLists = asignaturaDao.getAll();
    }

    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return AsignaturaLists;
    }

    public void insert(AsignaturaInsert asignatura) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.insert(asignatura)
        );
    }

    public void updateAsignatura(AsignaturaUpdate Asignatura) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.updateAsignatura(Asignatura)
        );
    }

    public void deleteAsignatura(AsignaturaId id) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> asignaturaDao.deleteAsignatura(id)
        );
    }

}
