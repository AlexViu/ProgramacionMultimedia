package com.aledom.matriculacionalumnos.data.alumnos;

public class AlumnoUpdate {
    public int id;
    String name;
    String apellidos;
    String dni;

    public AlumnoUpdate(int id, String name, String apellidos, String dni) {
        this.id = id;
        this.name = name;
        this.apellidos = apellidos;
        this.dni = dni;
    }
}
