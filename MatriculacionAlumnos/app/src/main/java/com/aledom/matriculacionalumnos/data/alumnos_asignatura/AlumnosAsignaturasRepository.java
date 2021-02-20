package com.aledom.matriculacionalumnos.data.alumnos_asignatura;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.alumnos_asignaturas.AlumnosAsignaturasForList;
import com.aledom.matriculacionalumnos.data.MatriculacionDatabase;

import java.util.List;

public class AlumnosAsignaturasRepository {
    private final LiveData<List<AlumnosAsignaturasForList>> AlumnosAsignaturasLists;
    private final AlumnosAsignaturaDao alumnoAsignaturaDao;

    public AlumnosAsignaturasRepository(Context context) {
        MatriculacionDatabase db = MatriculacionDatabase.getInstance(context);
        alumnoAsignaturaDao = db.AlumnoAsignaturaDao();
        AlumnosAsignaturasLists = AlumnosAsignaturaDao.getAll();
    }

    public LiveData<List<AlumnosAsignaturasForList>> getAllAlumnosAsignaturas() {
        return AlumnosAsignaturasLists;
    }

    public void insert(AlumnoAsignaturaInsert alumnoasignatura) {
        MatriculacionDatabase.dbExecutor.execute(
                () -> alumnoAsignaturaDao.insert((List<AlumnosAsignatura>) alumnoasignatura)
        );
    }

}
