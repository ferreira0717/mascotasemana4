package com.example.mascotas;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotas.db.BaseDatos;

import java.util.ArrayList;

public class FragmentHome extends Fragment {
    private ArrayList<Mascotas> mascotas;
    private RecyclerView listamascotas;
    private BaseDatos db;

    public FragmentHome() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        listamascotas = v.findViewById(R.id.rvmascotas2);
        LinearLayoutManager llm = new LinearLayoutManager(v.getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(llm);
        db = new BaseDatos(v.getContext());
        db.insertarMascota("Flex",R.drawable.perro1);
        db.insertarMascota("Moro",R.drawable.perro2);
        db.insertarMascota("Terry",R.drawable.perro3);
        db.insertarMascota("Max",R.drawable.perro4);
        db.insertarMascota("Dori",R.drawable.perro5);
        db.insertarMascota("Manchas",R.drawable.perro6);


        iniciaradaptador(v.getContext());


        return v;
    }

    public void iniciaradaptador(Context context){
        BaseDatos db = new BaseDatos(context);
        MascotaAdapter ma = new MascotaAdapter(db.obtenerMascotas());
        listamascotas.setAdapter(ma);
    }
}

