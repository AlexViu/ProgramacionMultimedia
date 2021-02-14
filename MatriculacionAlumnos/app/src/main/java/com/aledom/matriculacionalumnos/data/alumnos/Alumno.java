package com.aledom.matriculacionalumnos.data.alumnos;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "alumno")
public class Alumno {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "name")
    private final String name;

    @NonNull
    @ColumnInfo(name = "apellidos")
    private final String apellidos;

    @NonNull
    @ColumnInfo(name = "dni")
    private final String dni;

    public Alumno(@NonNull String name, @NonNull String apellidos, @NonNull String dni) {
        this.name = name;
        this.apellidos = apellidos;
        this.dni = dni;
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

    @NonNull
    public String getApellidos() {
        return apellidos;
    }

    @NonNull
    public String getDni() {
        return dni;
    }
}
