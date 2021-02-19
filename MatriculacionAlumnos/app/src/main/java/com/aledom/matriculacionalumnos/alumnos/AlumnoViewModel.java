package com.aledom.matriculacionalumnos.alumnos;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.data.alumnos.AlumnoInsert;
import com.aledom.matriculacionalumnos.data.alumnos.AlumnoRepository;
import com.aledom.matriculacionalumnos.data.alumnos.AlumnoUpdate;



import java.util.List;

public class AlumnoViewModel extends AndroidViewModel {
    private final AlumnoRepository mRepository;
    private final LiveData<List<AlumnosForList>> alumnos;


    public AlumnoViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AlumnoRepository(application);
        alumnos = mRepository.getAllAlumnos();
    }

    public LiveData<List<AlumnosForList>> getAllAlumnos() {
        return alumnos;
    }

    public void insert(AlumnoInsert alumno) {
        mRepository.insert(alumno);
    }

    public void updateAlumno(AlumnoUpdate Alumno) {
        mRepository.actualizar(Alumno);
    }

    public void deleteAlumno(AlumnosForList Alumno) {
        AlumnoId id = new AlumnoId(Alumno.id);
        mRepository.deleteAlumno(id);
    }
}
