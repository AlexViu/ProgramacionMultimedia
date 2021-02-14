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
import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;
import com.aledom.matriculacionalumnos.data.asignatura.AsiganturaAdapter;

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

    public void setItemListener(AlumnoAdapter.ItemListener listener) {
        mItemListener = listener;
    }

    public interface ItemListener {
        void onUpdateIconClicked(AlumnosForList Asignatura);
        void onDeleteIconClicked(AlumnosForList Asignatura);
    }

    public class AlumnoViewHolder extends RecyclerView.ViewHolder {

        private final TextView alumno_name;
        private final ImageView delete, update;

        public AlumnoViewHolder(@NonNull View itemView) {
            super(itemView);
            alumno_name = itemView.findViewById(R.id.name);
            delete = itemView.findViewById(R.id.delete_button);
            update = itemView.findViewById(R.id.update_button);

            delete.setOnClickListener(this::manageEvents);
            update.setOnClickListener(this::manageEvents);
            itemView.setOnClickListener(this::manageEvents);

        }

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
            }
        }

        public void bind(AlumnosForList item) {
            alumno_name.setText(item.name);

        }
    }
}
