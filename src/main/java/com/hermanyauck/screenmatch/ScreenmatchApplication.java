package com.hermanyauck.screenmatch;

import com.hermanyauck.screenmatch.models.*;
import com.hermanyauck.screenmatch.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
        ConsumirAPI serie = new ConsumirAPI("https://www.omdbapi.com/?t=game+of+thrones&apikey=fab839fa");
        var datosS = serie.obtenerDatos(DatosSerie.class);
        //System.out.println(datosS);

		ConsumirAPI episodio = new ConsumirAPI("https://www.omdbapi.com/?t=game+of+thrones&Season=1&Episode=1&apikey=fab839fa");
		var datosE = episodio.obtenerDatos(DatosEpisodio.class);
		//System.out.println(datosE);

		List<DatosTemporada> temporadasList = new ArrayList<>();
		//ConsumirAPI temporadas
		for (int i = 1; i <= datosS.temporadas() ; i++ ){
			ConsumirAPI temporadas = new ConsumirAPI("https://www.omdbapi.com/?t=game+of+thrones&Season="+i+"&apikey=fab839fa");
			var datosT = temporadas.obtenerDatos(DatosTemporada.class);
			temporadasList.add(datosT);
		}
		temporadasList.forEach(System.out::println);
	}
}
