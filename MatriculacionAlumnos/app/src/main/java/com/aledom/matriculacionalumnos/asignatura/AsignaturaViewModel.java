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

    //Contructor
    public AsignaturaViewModel(@NonNull Application application) {
        super(application);
        mRepository = new AsignaturaRepository(application);
        asignaturas = mRepository.getAllAsignaturas();
    }

    //metodo para devolver lista de asignaturas
    public LiveData<List<AsignaturaForList>> getAllAsignaturas() {
        return asignaturas;
    }

    //metodo para insertar asignaturas
    public void insert(AsignaturaInsert asignatura) {
        mRepository.insert(asignatura);
    }

    //metodo para actualizar asignaturas
    public void updateAsignatura(AsignaturaUpdate Asignatura) {
        AsignaturaId id = new AsignaturaId(Asignatura.id);
        mRepository.actualizar(Asignatura);
    }
    //Metodo para eliminar asignaturas
    public void deleteAsignatura(AsignaturaForList Asignatura) {
        AsignaturaId id = new AsignaturaId(Asignatura.id);
        mRepository.deleteAsignatura(id);
    }

}
