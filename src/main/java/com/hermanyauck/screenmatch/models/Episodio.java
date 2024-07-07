package com.hermanyauck.screenmatch.models;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Episodio {
    private String titulo;
    private Integer numEpisodio;
    private Double evaluacion;
    private LocalDate fechaPublicado;
    private Integer temporada;

    public Episodio(Integer temporada, DatosEpisodio d) {
        this.temporada = temporada;
        try{
            this.fechaPublicado = LocalDate.parse(d.fechaPublicado());
        } catch (DateTimeParseException e){
            this.fechaPublicado = null;
        }
        try{
            this.evaluacion = Double.valueOf(d.evaluacion());
        }catch (NumberFormatException e){
            this.evaluacion = 0.0;
        }
        this.numEpisodio = d.numEpisodio();
        this.titulo = d.titulo();
    }

    @Override
    public String toString() {
        return "titulo='" + titulo + '\'' +
                ", numEpisodio=" + numEpisodio +
                ", evaluacion=" + evaluacion +
                ", fechaPublicado=" + fechaPublicado +
                ", temporada=" + temporada;
    }
}
