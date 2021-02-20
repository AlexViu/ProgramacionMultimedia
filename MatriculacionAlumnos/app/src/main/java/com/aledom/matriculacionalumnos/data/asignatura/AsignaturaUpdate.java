package com.aledom.matriculacionalumnos.data.asignatura;

public class AsignaturaUpdate {
    public int id;
    int codigo_asignatura;
    String name;

    public AsignaturaUpdate(int id, int codigo_asignatura, String name) {
        this.id = id;
        this.codigo_asignatura = codigo_asignatura;
        this.name = name;
    }
}
