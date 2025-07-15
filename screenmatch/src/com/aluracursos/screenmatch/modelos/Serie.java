package com.aluracursos.screenmatch.modelos;

// extends: Herencia
public class Serie extends Titulo{
    private int temporadas;
    private int episodiosPorTemporada;
    private int minutosPorEpisodio;


    // Getters y Setters
    public void setTemporadas(int temporadas) {
        this.temporadas = temporadas;
    }

    public void setEpisodiosPorTemporada(int episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public void setMinutosPorEpisodio(int minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    public int getTemporadas() {
        return temporadas;
    }

    public int getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public int getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    @Override
    public int getDuracionEnMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio;
    }
}
