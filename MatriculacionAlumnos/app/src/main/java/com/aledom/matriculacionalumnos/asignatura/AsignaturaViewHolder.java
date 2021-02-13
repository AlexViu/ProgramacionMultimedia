package com.aledom.matriculacionalumnos.asignatura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aledom.matriculacionalumnos.R;
import com.aledom.matriculacionalumnos.data.asignatura.Asignatura;

public class AsignaturaViewHolder extends RecyclerView.ViewHolder{
    private final TextView mNameText;

    public AsignaturaViewHolder(@NonNull View itemView) {
        super(itemView);
        mNameText = itemView.findViewById(R.id.name);
    }

    public void bind(Asignatura item) {
        mNameText.setText(item.getName());
    }

    public static AsignaturaViewHolder create(ViewGroup parent) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.asignatura_item, parent, false);
        return new AsignaturaViewHolder(v);
    }
}
