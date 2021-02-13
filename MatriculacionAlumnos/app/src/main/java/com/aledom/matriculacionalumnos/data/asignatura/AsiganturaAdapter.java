package com.aledom.matriculacionalumnos.data.asignatura;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aledom.matriculacionalumnos.asignatura.AsignaturaViewHolder;

import java.util.List;

public class AsiganturaAdapter extends RecyclerView.Adapter<AsignaturaViewHolder>{
    private List<Asignatura> asignaturas;

    @NonNull
    @Override
    public AsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return AsignaturaViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull AsignaturaViewHolder holder, int position) {
        Asignatura item = asignaturas.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return asignaturas == null ? 0 : asignaturas.size();
    }

    public void setItems(List<Asignatura> items) {
        asignaturas = items;
        notifyDataSetChanged();
    }

}
