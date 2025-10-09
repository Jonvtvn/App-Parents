package com.app_parents_backend.backend;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		// Cargar las variables del archivo .env
		Dotenv dotenv = Dotenv.load();
		dotenv.entries().forEach(entry -> {
			// Convertir claves a formato esperado por Spring (puntos y minúsculas)
			String key = entry.getKey().toLowerCase().replace("_", ".");
			System.setProperty(key, entry.getValue());
		});

		// Iniciar la aplicación Spring Boot
		SpringApplication.run(BackendApplication.class, args);
	}

}
