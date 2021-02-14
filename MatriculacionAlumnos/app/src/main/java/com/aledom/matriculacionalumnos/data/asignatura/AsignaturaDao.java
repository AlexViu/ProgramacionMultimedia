package com.aledom.matriculacionalumnos.data.asignatura;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaId;

import java.util.List;

@Dao
public interface AsignaturaDao {

    @Query("SELECT * FROM asignatura")
    LiveData<List<AsignaturaForList>> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = Asignatura.class)
    void insert(AsignaturaInsert Asignatura);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertAsignaturas(List<Asignatura> asignaturas);

    @Delete(entity = Asignatura.class)
    void deleteAsignatura(AsignaturaId id);

    @Update(entity = Asignatura.class)
    default void updateAsignatura(AsignaturaUpdate Asignatura) {

    }
}
