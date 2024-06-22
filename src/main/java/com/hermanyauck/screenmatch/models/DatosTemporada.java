package com.hermanyauck.screenmatch.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosTemporada(

        @JsonAlias("Episodes")
        List<DatosEpisodio> episodio,

        @JsonAlias("Season")
        Integer numTemporada,

        @JsonAlias("totalSeasons")
        Integer cantEpisodios
) {
}
