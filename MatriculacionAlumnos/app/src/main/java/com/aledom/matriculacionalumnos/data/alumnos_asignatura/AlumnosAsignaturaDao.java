package com.aledom.matriculacionalumnos.data.alumnos_asignatura;

import androidx.lifecycle.LiveData;
import androidx.room.*;

import com.aledom.matriculacionalumnos.alumnos_asignaturas.AlumnosAsignaturasForList;

import java.util.List;

@Dao
public abstract class AlumnosAsignaturaDao {

    @Query("SELECT * FROM alumnos_asigntura alas INNER JOIN asignatura asi ON asi.id = alas.asignatura_id")
    static LiveData<List<AlumnosAsignaturasForList>> getAll() {
        return null;
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void insert(List<AlumnosAsignatura> alumnosAsignaturas);

}
