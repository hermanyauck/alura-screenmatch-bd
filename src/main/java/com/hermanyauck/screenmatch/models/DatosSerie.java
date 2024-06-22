package com.hermanyauck.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
      @JsonAlias("Title")
      String Titulo,

      @JsonAlias("Year")
      String Anio,

      @JsonAlias("totalSeasons")
      Integer Temporadas,

      @JsonAlias("imdbRating")
      Float Evaluacion) {

}
