// Este archivo es el punto de entrada de la aplicación Spring Boot. 
// La anotación @SpringBootApplication indica que esta clase es la 
// configuración principal de la aplicación y habilita la configuración 
// automática, el escaneo de componentes y otras características de Spring Boot. 
// El método main inicia la aplicación ejecutando SpringApplication.run() con la 
// clase principal y los argumentos proporcionados.
package com.ejemplo.conexiondb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConexionDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConexionDbApplication.class, args);
	}

}
