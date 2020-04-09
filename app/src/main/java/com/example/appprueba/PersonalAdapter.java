package com.example.appprueba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import java.util.Locale;

class PersonalAdapter extends RecyclerView.Adapter<PersonalAdapter.ViewHolder> {
    private List<Personal> personals;
    PersonalAdapter(List<Personal> personals) {
        this.personals = personals;
    }

    @NonNull
    @Override
    public PersonalAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_personales, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonalAdapter.ViewHolder holder, int position) {
        holder.nombre.setText(String.format(Locale.getDefault(),"Nombre: %s", personals.get(position).getNombre()));
        holder.apellido.setText(String.format(Locale.getDefault(),"Apellidos: %s", personals.get(position).getApellidos()));
        holder.direccion.setText(String.format(Locale.getDefault(),"Dirección: %s", personals.get(position).getDireccion()));
        holder.ine.setText(String.format(Locale.getDefault(),"INE: %s", personals.get(position).getIne()));
        holder.telefono.setText(String.format(Locale.getDefault(),"Telefono: %d", personals.get(position).getTelefono()));
        holder.puesto.setText(String.format(Locale.getDefault(),"Puesto: %s", personals.get(position).getPuesto()));
    }

    @Override
    public int getItemCount() {
        return personals.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, apellido, direccion, ine, telefono, puesto;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            apellido = itemView.findViewById(R.id.tvApellido);
            direccion =itemView.findViewById(R.id.tvDireccion);
            ine = itemView.findViewById(R.id.tvIne);
            telefono = itemView.findViewById(R.id.tvTelefono);
            puesto = itemView.findViewById(R.id.tvPuesto);

        }
    }
}
