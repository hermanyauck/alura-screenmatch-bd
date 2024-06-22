package com.hermanyauck.screenmatch;

import com.hermanyauck.screenmatch.models.DatosSerie;
import com.hermanyauck.screenmatch.services.ConvertDatos;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hermanyauck.screenmatch.services.ConsumirAPI;

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
		System.out.println(datos);
	}
}
