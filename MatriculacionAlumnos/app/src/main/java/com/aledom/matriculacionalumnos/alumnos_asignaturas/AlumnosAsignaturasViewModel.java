package com.aledom.matriculacionalumnos.alumnos_asignaturas;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.data.alumnos_asignatura.AlumnoAsignaturaInsert;
import com.aledom.matriculacionalumnos.data.alumnos_asignatura.AlumnosAsignaturasRepository;

import java.util.List;

public class AlumnosAsignaturasViewModel extends AndroidViewModel {
    private final AlumnosAsignaturasRepository mRepository;
    private final LiveData<List<AlumnosAsignaturasForList>> alumnosAsignaturas;


    public AlumnosAsignaturasViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AlumnosAsignaturasRepository(application);
        alumnosAsignaturas = mRepository.getAllAlumnosAsignaturas();
    }

    public LiveData<List<AlumnosAsignaturasForList>> getAllAlumnosAsignaturas() {
        return alumnosAsignaturas;
    }

    public void insert(AlumnoAsignaturaInsert alumno) {
        mRepository.insert(alumno);
    }


}
