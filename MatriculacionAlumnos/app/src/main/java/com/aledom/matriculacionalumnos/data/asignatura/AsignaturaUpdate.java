package com.aledom.matriculacionalumnos.data.asignatura;

public class AsignaturaUpdate {
    public int id;
    int codigo_asignatura;
    String name;

    public AsignaturaUpdate(int codigo_asignatura, String name) {
        this.codigo_asignatura = codigo_asignatura;
        this.name = name;
    }
}
