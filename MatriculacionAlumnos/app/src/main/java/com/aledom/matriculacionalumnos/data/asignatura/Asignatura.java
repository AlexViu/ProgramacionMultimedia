package com.aledom.matriculacionalumnos.data.asignatura;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "asignatura")
public class Asignatura {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "codigo_asignatura")
    private int codigo_asignatura;

    @NonNull
    @ColumnInfo(name = "name")
    private final String name;


    public Asignatura(int codigo_asignatura, @NonNull String name) {
        this.codigo_asignatura = codigo_asignatura;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCodigo_asignatura() {
        return codigo_asignatura;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
