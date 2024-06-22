package com.hermanyauck.screenmatch;

import com.hermanyauck.screenmatch.models.DatosEpisodio;
import com.hermanyauck.screenmatch.models.DatosSerie;
import com.hermanyauck.screenmatch.models.DatosTemporada;
import com.hermanyauck.screenmatch.services.ConvertDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hermanyauck.screenmatch.services.ConsumirAPI;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		var consumoAPI = new ConsumirAPI();
		var json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&apikey=fab839fa");
		//System.out.println(json);
		ConvertDatos conversor = new ConvertDatos();
		var datos = conversor.obtenerDatos(json, DatosSerie.class);

		json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season=1&Episode=1&apikey=fab839fa");
		DatosEpisodio episodio = conversor.obtenerDatos(json, DatosEpisodio.class);
		//System.out.println(episodio);

		List<DatosTemporada> temporadas = new ArrayList<>();

		for (int i = 1; i <= datos.temporadas() ; i++ ){
			json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+thrones&Season="+i+"&apikey=fab839fa");
			var temporada = conversor.obtenerDatos(json, DatosTemporada.class);
			temporadas.add(temporada);
		}
		temporadas.forEach(System.out::println);
	}
}
