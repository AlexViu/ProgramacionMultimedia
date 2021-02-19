package com.aledom.matriculacionalumnos.data.alumnos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.aledom.matriculacionalumnos.alumnos.AlumnoId;
import com.aledom.matriculacionalumnos.alumnos.AlumnosForList;

import java.util.List;

@Dao
public interface AlumnoDao {

    @Query("SELECT * FROM alumno")
    LiveData<List<AlumnosForList>> getAll();

    @Query(("UPDATE alumno SET name=:name, apellidos=:apellidos WHERE dni = :dni"))
    void actualizar(String name, String apellidos, String dni);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Alumno.class)
    void insert(AlumnoInsert Alumno);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAlumnos(List<Alumno> alumnos);

    @Delete(entity = Alumno.class)
    void deleteAlumno(AlumnoId id);


}
