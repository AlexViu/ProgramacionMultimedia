package com.aledom.matriculacionalumnos.data.asignatura;

import androidx.annotation.NonNull;
import androidx.room.*;

@Entity(tableName = "asignatura")
public class Asignatura {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private final String name;

    public Asignatura(@NonNull String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }
}
