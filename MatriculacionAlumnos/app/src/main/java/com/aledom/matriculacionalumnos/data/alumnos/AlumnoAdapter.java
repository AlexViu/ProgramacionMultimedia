package com.aledom.matriculacionalumnos.data.alumnos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aledom.matriculacionalumnos.R;
import com.aledom.matriculacionalumnos.alumnos.AlumnosForList;

import java.util.List;


public class AlumnoAdapter extends RecyclerView.Adapter<AlumnoAdapter.AlumnoViewHolder> {
    private List<AlumnosForList> Alumnos;
    private AlumnoAdapter.ItemListener mItemListener;

    @NonNull
    @Override
    public AlumnoAdapter.AlumnoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlumnoAdapter.AlumnoViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alumno_item, parent, false)
        );
    }


    @Override
    public void onBindViewHolder(@NonNull AlumnoAdapter.AlumnoViewHolder holder, int position) {
        AlumnosForList item = Alumnos.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Alumnos == null ? 0 : Alumnos.size();
    }

    public void setItems(List<AlumnosForList> items) {
        Alumnos = items;
        notifyDataSetChanged();
    }

    //listener de los botones de la lista
    public void setItemListener(AlumnoAdapter.ItemListener listener) {
        mItemListener = listener;
    }

    public interface ItemListener {
        void onUpdateIconClicked(AlumnosForList Alumno);
        void onDeleteIconClicked(AlumnosForList Alumno);
        void onAsignaturasIconClicked(AlumnosForList Alumno);
    }

    //Obtener datos de los elementos
    public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        private final TextView alumno_name, alumno_apellido, alumno_dni;
        private final ImageView delete, update, asignatura;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            alumno_name = itemView.findViewById(R.id.name);
            alumno_apellido = itemView.findViewById(R.id.apellido);
            alumno_dni = itemView.findViewById(R.id.dni);
            delete = itemView.findViewById(R.id.delete_button);
            update = itemView.findViewById(R.id.update_button);
            asignatura = itemView.findViewById(R.id.asignatura_button);

            delete.setOnClickListener(this::manageEvents);
            update.setOnClickListener(this::manageEvents);
            asignatura.setOnClickListener(this::manageEvents);
            itemView.setOnClickListener(this::manageEvents);

        }

        //Funciones de los botones de la lista
        private void manageEvents(View view) {
            if (mItemListener != null) {
                AlumnosForList clickedItem = Alumnos.get(getAdapterPosition());

                if (view.getId() == R.id.delete_button) {
                    mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }
                if (view.getId() == R.id.update_button) {
                    mItemListener.onUpdateIconClicked(clickedItem);
                    return;
                }
                if (view.getId() == R.id.asignatura_button) {
                    mItemListener.onAsignaturasIconClicked(clickedItem);
                    return;
                }
            }
        }

        //Añadir informacion en la lista
        public void bind(AlumnosForList item) {
            alumno_name.setText(item.name);
            alumno_apellido.setText(item.apellidos);
            alumno_dni.setText(item.dni);

        }
    }
}
