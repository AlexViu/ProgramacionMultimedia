package com.aledom.matriculacionalumnos.data.asignatura;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.aledom.matriculacionalumnos.R;
import com.aledom.matriculacionalumnos.asignatura.AsignaturaForList;

import java.util.List;

public class AsiganturaAdapter extends RecyclerView.Adapter<AsiganturaAdapter.AsignaturaViewHolder>{
    private List<AsignaturaForList> Asignaturas;
    private ItemListener mItemListener;

    @NonNull
    @Override
    public AsignaturaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AsignaturaViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.asignatura_item, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull AsignaturaViewHolder holder, int position) {
        AsignaturaForList item = Asignaturas.get(position);
        holder.bind(item);
    }

    @Override
    public int getItemCount() {
        return Asignaturas == null ? 0 : Asignaturas.size();
    }

    public void setItems(List<AsignaturaForList> items) {
        Asignaturas = items;
        notifyDataSetChanged();
    }

    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }

    public interface ItemListener {
        void onUpdateIconClicked(AsignaturaForList Asignatura);
        void onDeleteIconClicked(AsignaturaForList Asignatura);
    }

    public class AsignaturaViewHolder extends RecyclerView.ViewHolder {

        private final TextView asignatura_name, asignatura_code;
        private final ImageView delete, update;

        public AsignaturaViewHolder(@NonNull View itemView) {
            super(itemView);
            asignatura_code = itemView.findViewById(R.id.codigo_asignatura);
            asignatura_name = itemView.findViewById(R.id.name);
            delete = itemView.findViewById(R.id.delete_button);
            update = itemView.findViewById(R.id.update_button);

            delete.setOnClickListener(this::manageEvents);
            update.setOnClickListener(this::manageEvents);
            itemView.setOnClickListener(this::manageEvents);

        }

        private void manageEvents(View view) {
            if (mItemListener != null) {
                AsignaturaForList clickedItem = Asignaturas.get(getAdapterPosition());

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

        public void bind(AsignaturaForList item) {
            String codigo = "" + item.codigo_asignatura;
            asignatura_code.setText(codigo);
            asignatura_name.setText(item.name);

        }
    }
}
