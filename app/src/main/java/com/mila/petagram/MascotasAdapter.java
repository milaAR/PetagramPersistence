package com.mila.petagram;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MascotasAdapter extends RecyclerView.Adapter<MascotasAdapter.ViewHolder> {
    List<Mascotas> mascotas;
    Context context;
    LayoutInflater layoutInflater;
    int contador;


    public MascotasAdapter(List<Mascotas> mascotas, Context context) {
        this.mascotas = mascotas;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Mascotas mascota = mascotas.get(position);
        holder.imagenMascota.setImageResource(mascota.getRutaFoto());
        holder.nombreMascota.setText(mascota.getNombreMascota());
        holder.numeroMascota.setText(mascota.getHuesoTop()+"");
        holder.botonHueso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mascota.getHuesoTop()==0)
                {
                    if(contador<=5)
                    {
                        holder.numeroMascota.setText(""+contador);
                        mascota.setHuesoTop(contador);
                        contador++;
                    }
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imagenMascota;
        TextView nombreMascota, numeroMascota;
        ImageButton botonHueso;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imagenMascota =itemView.findViewById(R.id.imagenMascota);
            nombreMascota = itemView.findViewById(R.id.nombreMascota);
            botonHueso = itemView.findViewById(R.id.icono_hueso);
            numeroMascota = itemView.findViewById(R.id.numeroMascotaFavotita);
        }
    }
}
