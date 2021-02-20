package com.aledom.matriculacionalumnos.data.alumnos_asignatura;

import androidx.annotation.NonNull;
import androidx.room.*;

import com.aledom.matriculacionalumnos.data.alumnos.Alumno;
import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;


@Entity(tableName = "alumnos_asigntura",
        primaryKeys = {"alumno_id", "asignatura_id"},
        foreignKeys = {
                @ForeignKey(
                        entity = Alumno.class,
                        parentColumns = "id",
                        childColumns = "alumno_id",
                        onDelete = ForeignKey.CASCADE),
                @ForeignKey(
                        entity = Asignatura.class,
                        parentColumns = "id",
                        childColumns = "asignatura_id")
        }
)

public class AlumnosAsignatura {
    @NonNull
    @ColumnInfo(name = "alumno_id")
    public String alumnoId;

    @NonNull
    @ColumnInfo(name = "asignatura_id")
    public String asignaturaId;

    public AlumnosAsignatura(@NonNull String alumnoId, @NonNull String asignaturaId) {
        this.alumnoId = alumnoId;
        this.asignaturaId = asignaturaId;
    }
}
