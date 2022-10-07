package com.example.mascotas;

import static android.graphics.Color.parseColor;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.db.BaseDatos;

import java.util.ArrayList;

public class MascotagridAdapter extends RecyclerView.Adapter<MascotagridAdapter.MascotaViewHolder> {
    ArrayList<Mascotas> mascotas;
    Context context;
    public MascotagridAdapter(ArrayList<Mascotas> m){
    this.mascotas = m;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjetagrid,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        BaseDatos db = new BaseDatos(holder.fotomascota.getContext());
        Mascotas mascota = mascotas.get(position);
        holder.fotomascota.setImageResource(mascota.getFoto());
        holder.like2.setBackgroundColor(parseColor("#FFEB3B"));
        mascota.setRating(db.obtenerRatingMascota(mascota));
        holder.contador.setText(String.valueOf(mascota.getRating()));
        db.close();


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private final AppCompatImageView fotomascota;
        private final AppCompatImageButton like2;
        private final TextView contador;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            fotomascota = itemView.findViewById(R.id.fotomascota);
            like2 = itemView.findViewById(R.id.like2);
            contador = itemView.findViewById(R.id.contador);
        }
    }
}
