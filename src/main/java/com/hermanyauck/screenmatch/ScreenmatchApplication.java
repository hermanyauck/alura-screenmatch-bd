package com.hermanyauck.screenmatch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.hermanyauck.screenmatch.modelos.ConsumirAPI;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		var consumoAPI = new ConsumirAPI();
		var json = consumoAPI.obtenerDatos("https://www.omdbapi.com/?t=game+of+throne&apikey=fab839fa");
		System.out.println(json);
	}
}
