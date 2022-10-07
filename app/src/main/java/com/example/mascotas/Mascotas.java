package com.example.mascotas;

public class Mascotas {
    private String nombre;
    private int id,foto,rating=0;

    public Mascotas(){}

    public Mascotas(int id,int foto, int rating){
        this.id = id;
        this.foto = foto;
        this.rating = rating;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getContador() {
        return rating;
    }

    public void setContador(int contador) {
        this.rating = contador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
