package com.aledom.matriculacionalumnos.data.asignatura;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;



import java.util.List;

@Dao
public interface AsignaturaDao {

    @Query("SELECT * FROM asignatura")
    LiveData<List<Asignatura>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Asignatura.class)
    void insert(Asignatura Asignatura);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAsignaturas(List<Asignatura> asignaturas);

    @Update(entity = Asignatura.class)
    void updateAsignatura(Asignatura Asignatura);
}
