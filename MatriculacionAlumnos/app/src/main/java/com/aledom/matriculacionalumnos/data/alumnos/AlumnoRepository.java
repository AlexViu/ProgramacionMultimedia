package com.aledom.matriculacionalumnos.data.alumnos;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.alumnos.AlumnoId;
import com.aledom.matriculacionalumnos.alumnos.AlumnosForList;
import com.aledom.matriculacionalumnos.data.MatriculacionDatabase;


import java.util.List;

public class AlumnoRepository {

    private final LiveData<List<AlumnosForList>> AlumnosLists;
    private final AlumnoDao alumnoDao;

    public AlumnoRepository(Context context) {
        MatriculacionDatabase db = MatriculacionDatabase.getInstance(context);
        alumnoDao = db.AlumnoDao();
        AlumnosLists = alumnoDao.getAll();
    }

    public LiveData<List<AlumnosForList>> getAllAlumnos() {
        return AlumnosLists;
    }

    public void insert(AlumnoInsert alumno) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> alumnoDao.insert(alumno)
        );
    }

    public void actualizar(AlumnoUpdate alumno) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> alumnoDao.actualizar(alumno.name, alumno.apellidos, alumno.dni)
        );
    }

    public void deleteAlumno(AlumnoId id) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> alumnoDao.deleteAlumno(id)
        );
    }
}
