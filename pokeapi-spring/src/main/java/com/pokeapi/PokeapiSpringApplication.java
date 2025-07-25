package com.pokeapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // Marca la clase como la principal de Spring Boot y habilita la configuración automática
public class PokeapiSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(PokeapiSpringApplication.class, args); // Inicia la aplicación Spring Boot
    }
} 