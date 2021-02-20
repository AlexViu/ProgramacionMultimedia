package com.aledom.matriculacionalumnos.data.alumnos_asignatura;

import androidx.room.*;

import java.util.List;

@Dao
public abstract class AlumnosAsignaturaDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void insertAll(List<AlumnosAsignatura> alumnosAsignaturas);
}
