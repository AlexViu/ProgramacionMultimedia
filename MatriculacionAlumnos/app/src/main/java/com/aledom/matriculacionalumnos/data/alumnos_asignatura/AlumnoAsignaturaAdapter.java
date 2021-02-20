package com.aledom.matriculacionalumnos.data.alumnos_asignatura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aledom.matriculacionalumnos.R;
import com.aledom.matriculacionalumnos.alumnos_asignaturas.AlumnosAsignaturasForList;

import java.util.List;

public class AlumnoAsignaturaAdapter extends RecyclerView.Adapter<AlumnoAsignaturaAdapter.AlumnoAsignaturaViewHolder> {
    private List<AlumnosAsignaturasForList> AlumnosAsignaturas;
    private AlumnoAsignaturaAdapter.ItemListener mItemListener;


    @NonNull
    @Override
    public AlumnoAsignaturaAdapter.AlumnoAsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AlumnoAsignaturaAdapter.AlumnoAsignaturaViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.alumno_asignatura_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AlumnoAsignaturaAdapter.AlumnoAsignaturaViewHolder holder, int position) {
        AlumnosAsignaturasForList item = AlumnosAsignaturas.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return AlumnosAsignaturas == null ? 0 : AlumnosAsignaturas.size();
    }

    public void setItems(List<AlumnosAsignaturasForList> items) {
        AlumnosAsignaturas = items;
        notifyDataSetChanged();
    }

    public void setItemListener(AlumnoAsignaturaAdapter.ItemListener listener) {
        mItemListener = listener;
    }

    public interface ItemListener {
        void onDeleteIconClicked(AlumnosAsignaturasForList Asignatura);
    }

    public class AlumnoAsignaturaViewHolder extends RecyclerView.ViewHolder {

        private final TextView asignatura_name, asignatura_code;
        private final ImageView delete;

        public AlumnoAsignaturaViewHolder(@NonNull View itemView) {
            super(itemView);
            asignatura_code = itemView.findViewById(R.id.codigo_asignatura);
            asignatura_name = itemView.findViewById(R.id.name);
            delete = itemView.findViewById(R.id.delete_button);
            
            delete.setOnClickListener(this::manageEvents);
            itemView.setOnClickListener(this::manageEvents);

        }

        private void manageEvents(View view) {
            if (mItemListener != null) {
                AlumnosAsignaturasForList clickedItem = AlumnosAsignaturas.get(getAdapterPosition());

                if (view.getId() == R.id.delete_button) {
                    mItemListener.onDeleteIconClicked(clickedItem);
                    return;
                }
            }
        }

        public void bind(AlumnosAsignaturasForList item) {
            String codigo = "" + item.codigo_asignatura;
            asignatura_code.setText(codigo);
            asignatura_name.setText(item.name);

        }
    }
}
