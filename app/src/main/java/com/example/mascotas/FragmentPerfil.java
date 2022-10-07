package com.example.mascotas;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mascotas.db.BaseDatos;

import java.util.ArrayList;


public class FragmentPerfil extends Fragment {

    ArrayList<Mascotas> mascotasFavoritas;
    private RecyclerView listamascotas;
    private BaseDatos db;
    public FragmentPerfil() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        listamascotas = v.findViewById(R.id.rvgrid);
        GridLayoutManager glm = new GridLayoutManager(v.getContext(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);
        listamascotas.setLayoutManager(glm);

        db = new BaseDatos(v.getContext());

        iniciaradaptador(v.getContext());


        return v;
    }

    public void iniciaradaptador(Context context){
        MascotagridAdapter ma = new MascotagridAdapter(db.obtenerMascotasFavoritas());
        listamascotas.setAdapter(ma);
    }


}