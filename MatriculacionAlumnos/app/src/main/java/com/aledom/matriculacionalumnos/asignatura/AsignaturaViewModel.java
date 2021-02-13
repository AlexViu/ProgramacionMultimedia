package com.aledom.matriculacionalumnos.asignatura;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaInsert;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaRepository;

import java.util.List;

public class AsignaturaViewModel extends AndroidViewModel {
    //varibales
    private final AsignaturaRepository mRepository;
    private final LiveData<List<Asignatura>> asignaturas;

    public AsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AsignaturaRepository(application);
        asignaturas = mRepository.getAllAsignaturas();
    }

    public LiveData<List<Asignatura>> getAllAsignaturas() {
        return asignaturas;
    }

    public void insert(AsignaturaInsert asignatura) {
        mRepository.insert(asignatura);
    }

    public void updateAsignatura(Asignatura Asignatura) {
        mRepository.updateAsignatura(Asignatura);
    }

}
