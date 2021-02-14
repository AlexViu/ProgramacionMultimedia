package com.aledom.matriculacionalumnos.asignatura;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaInsert;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaRepository;
import com.aledom.matriculacionalumnos.data.asignatura.AsignaturaUpdate;

import java.util.List;

public class AsignaturaViewModel extends AndroidViewModel {

    private final AsignaturaRepository mRepository;
    private final LiveData<List<AsignaturaForList>> asignaturas;


    public AsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AsignaturaRepository(application);
        asignaturas = mRepository.getAllAsignaturas();
    }

    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return asignaturas;
    }

    public void insert(AsignaturaInsert asignatura) {
        mRepository.insert(asignatura);
    }

    public void updateAsignatura(AsignaturaUpdate Asignatura) {
        mRepository.updateAsignatura(Asignatura);
    }

    public void deleteAsignatura(AsignaturaForList Asignatura) {
        AsignaturaId id = new AsignaturaId(Asignatura.id);
        mRepository.deleteAsignatura(id);
    }

}
