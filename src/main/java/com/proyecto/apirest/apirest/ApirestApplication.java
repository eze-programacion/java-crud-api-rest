package com.proyecto.apirest.apirest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // es una anotacion que hace la configuracion inicial de SpringBoot.
public class ApirestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApirestApplication.class, args); // @SpringBootApplication permite aplicar esto.
	}

}
