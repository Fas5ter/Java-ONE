package com.alura.screenmatch.principal;

import com.alura.screenmatch.calculos.CalculadoraDeTiempo;
import com.alura.screenmatch.calculos.FiltroRecomendacion;
import com.alura.screenmatch.modelos.Episodio;
import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
//        miPelicula.setNombre("Encanto");
//        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(180);
        System.out.println("Duración de la película: " + miPelicula.getDuracionEnMinutos());

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(8);
        miPelicula.evalua(5);
        miPelicula.evalua(10);
        System.out.println("Total de evaluaciones: " + miPelicula.getTotalDeEvaluaciones());
        System.out.println(miPelicula.calculaMediaEvaluaciones());


        Serie lost = new Serie("Lost", 2000);
//        lost.setNombre("Lost");
//        lost.setFechaDeLanzamiento(2000);
        lost.muestraFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duracion de la série: " + lost.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
//        otraPelicula.setNombre("Avatar");
//        otraPelicula.setFechaDeLanzamiento(2023);
        otraPelicula.setDuracionEnMinutos(200);

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluido(miPelicula);
        calculadora.incluido(otraPelicula);
        calculadora.incluido(lost);
        System.out.println(calculadora.getTiempoTotal());

        FiltroRecomendacion filtro = new FiltroRecomendacion();
        filtro.filtra(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizaciones(300);
        filtro.filtra(episodio);

        var peliculaDeCristian = new Pelicula("El señor de los anillos", 2001);
//        peliculaDeCristian.setNombre();
        peliculaDeCristian.setDuracionEnMinutos(180);
//        peliculaDeCristian.setFechaDeLanzamiento(2001);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeCristian);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);

        System.out.println("Tamaño de la lista: " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.toString());

        System.out.println("toString de la pelicula: " + listaDePeliculas.get(0).toString());

        Object objeto = peliculaDeCristian;
    }
}