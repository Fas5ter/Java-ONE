package com.alura.screenmatch.principal;

import com.alura.screenmatch.modelos.Pelicula;
import com.alura.screenmatch.modelos.Serie;
import com.alura.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.evalua(9);
        var peliculaDeCristian = new Pelicula("El señor de los anillos", 2001);
        peliculaDeCristian.evalua(10);
        Pelicula otraPelicula = new Pelicula("Avatar", 2023);
        otraPelicula.evalua(6);
        Serie lost = new Serie("Lost", 2000);

        // Copia pero no cambia el valor
        int numero1 = 1;
        int numero2 = numero1;

        // Hace referencia al objeto en memoria
        Pelicula p1 = peliculaDeCristian;

        // Pelicula y Serie heredan de la super clase Titulo
        ArrayList<Titulo> lista = new ArrayList<>();
//        List<Titulo> lista = new ArrayList<>();
//        List<Titulo> lista = new LinkedList<>();
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(peliculaDeCristian);
        lista.add(lost);

        for (Titulo item : lista) {
            System.out.println(item.getNombre());
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() > 2) {
                System.out.println((pelicula.getClasificacion()));
            }
        }

        ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Penélope Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darín");
        System.out.println("Lista de artistas no ordenada" + listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas no ordenada" + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("Lista ordenada por fecha: " + lista);
    }
}
