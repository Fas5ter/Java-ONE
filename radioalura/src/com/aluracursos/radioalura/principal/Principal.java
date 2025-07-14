package com.aluracursos.radioalura.principal;

import com.aluracursos.radioalura.modelos.Cancion;
import com.aluracursos.radioalura.modelos.MisFavoritos;
import com.aluracursos.radioalura.modelos.Podcast;

public class Principal {
    public static void main(String[] args) {
        Cancion cancion = new Cancion();
        cancion.setTitulo("Forever");
        cancion.setCantante("Kiss");

        Podcast podcast = new Podcast();
        podcast.setPresentador("Cristian Larios");
        podcast.setTitulo("Cafe.Tech");

        // Cancion
        for (int i = 0; i < 100; i++) {
            cancion.meGusta();
        }

        for (int i = 0; i < 500; i++) {
            cancion.reproduce();
        }
        // Podcast
        for (int i = 0; i < 2000; i++) {
            podcast.reproduce();
        }

        for (int i = 0; i < 8000; i++) {
            podcast.meGusta();
        }



        System.out.println("Total de reproducciones: " + cancion.getTotalDeReproducciones());
        System.out.println("Total de me gusta: " + cancion.getTotalDeMeGusta());
        System.out.println("********************************");
        System.out.println("Total de me gusta: " + podcast.getTotalDeMeGusta());
        System.out.println("Total de reproducciones: " + podcast.getTotalDeReproducciones());

        MisFavoritos misFavoritos = new MisFavoritos();
        misFavoritos.adicione(podcast);
        misFavoritos.adicione(cancion);
    }
}
