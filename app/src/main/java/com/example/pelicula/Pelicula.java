package com.example.pelicula;

public class Pelicula {
    private String mNom,mGenero;

    public Pelicula(String nom, String genero){
        this.mNom = nom;
        this.mGenero = genero;
    }

    public String getmNom() {
        return mNom;
    }

    public void setmNom(String mNom) {
        this.mNom = mNom;
    }

    public String getmGenero() {
        return mGenero;
    }

    public void setmGenero(String mGenero) {
        this.mGenero = mGenero;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "mNom='" + mNom + '\'' +
                ", mGenero='" + mGenero + '\'' +
                '}';
    }
}
