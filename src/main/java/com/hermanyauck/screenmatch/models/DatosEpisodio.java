package com.hermanyauck.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosEpisodio(
    @JsonAlias("Title")
    String titulo,

    @JsonAlias("Episode")
    Integer numEpisodio,

    @JsonAlias("imdbRating")
    Float evaluacion,

    @JsonAlias("Released")
    String fechaPublicado) {
}
