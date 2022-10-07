package com.example.mascotas;

import android.app.Dialog;
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


import java.util.ArrayList;

import static android.graphics.Color.parseColor;

import com.example.mascotas.db.BaseDatos;

public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder> {
    ArrayList<Mascotas> mascotas;

    public MascotaAdapter(ArrayList<Mascotas> m){
    this.mascotas = m;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_tarjeta,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MascotaViewHolder holder, int position) {
        Mascotas mascota = mascotas.get(position);
        holder.fotomascota.setImageResource(mascota.getFoto());
        holder.contador.setText(String.valueOf(mascota.getContador()));
        holder.nombre.setText(mascota.getNombre());
        holder.like2.setBackgroundColor(parseColor("#FFEB3B"));
        holder.like.setImageResource(R.drawable.ic_action_name);
        holder.like.setOnClickListener(view -> {
            final Dialog dialog =new Dialog(view.getContext());
            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            dialog.setContentView(R.layout.rating);
            dialog.show();
            dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
            dialog.getWindow().setGravity(Gravity.CENTER);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));



       RatingBar ratingBar = dialog.findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                BaseDatos db = new BaseDatos(view.getContext());
                mascota.setRating((int)rating);
                db.insertarRating(mascota);
                holder.contador.setText(String.valueOf((db.obtenerRatingMascota(mascota))));
                db.close();


            }
        });
       });
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private final AppCompatImageView fotomascota;
        private final AppCompatImageButton like,like2;
        private final TextView contador,nombre;


        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            fotomascota = itemView.findViewById(R.id.fotomascota);
            like = itemView.findViewById(R.id.like);
            like2 = itemView.findViewById(R.id.like2);
            contador = itemView.findViewById(R.id.contador);
            nombre = itemView.findViewById(R.id.nombre);
        }
    }
}
