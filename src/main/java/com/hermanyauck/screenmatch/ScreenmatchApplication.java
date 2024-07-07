package com.hermanyauck.screenmatch;

import com.hermanyauck.screenmatch.models.*;
import com.hermanyauck.screenmatch.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Cual serie quiere consultar: ");
		Scanner teclado = new Scanner(System.in);
		String inSerie = teclado.nextLine().replace(" ","+");


		ConsumirAPI serie = new ConsumirAPI("https://www.omdbapi.com/?t="+inSerie+"&apikey=fab839fa");
		//System.out.println(serie.getJson());
		//System.out.println(serie.getUrl());
        var datosS = serie.obtenerDatos(DatosSerie.class);
        System.out.println(datosS);

//		ConsumirAPI episodio = new ConsumirAPI("https://www.omdbapi.com/?t="+inSerie+"&Season=1&Episode=1&apikey=fab839fa");
//		var datosE = episodio.obtenerDatos(DatosEpisodio.class);
//		System.out.println(datosE);

		List<DatosTemporada> temporadasList = new ArrayList<>();
		for (int i = 1; i <= datosS.temporadas() ; i++ ){
			ConsumirAPI temporadas = new ConsumirAPI("https://www.omdbapi.com/?t="+inSerie+"&Season="+i+"&apikey=fab839fa");
			var datosT = temporadas.obtenerDatos(DatosTemporada.class);
			temporadasList.add(datosT);
		}
		//temporadasList.forEach(t -> t.episodio().forEach(e -> System.out.println(e)));
		//temporadasList.forEach(t -> t.episodio().forEach(System.out::println));
		List<DatosEpisodio> datosEpisodios = temporadasList.stream()
				.flatMap(t -> t.episodio().stream())
				.toList();

		datosEpisodios.stream()
				.filter(e -> !e.evaluacion().equals("N/A"))
				.sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
				.limit(5)
				.forEach(System.out::println);
	}
}
