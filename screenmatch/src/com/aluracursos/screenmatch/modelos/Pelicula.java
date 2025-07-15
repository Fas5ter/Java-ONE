package com.aluracursos.screenmatch.modelos;


import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Pelicula extends Titulo implements Clasificacion {
    private String director;


    // Getters y setters
    public void setDirector(String director) {
        this.director = director;
    }
    public String getDirector() {
        return director;
    }

    @Override
    public int getClasificacion() {
        return (int) (calculaMedia() / 2);
    }
}
