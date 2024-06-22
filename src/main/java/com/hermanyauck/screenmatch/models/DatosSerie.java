package com.hermanyauck.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
      @JsonAlias("Title")
      String titulo,

      @JsonAlias("Year")
      String anio,

      @JsonAlias("totalSeasons")
      Integer temporadas,

      @JsonAlias("imdbRating")
      Float evaluacion) {

}
