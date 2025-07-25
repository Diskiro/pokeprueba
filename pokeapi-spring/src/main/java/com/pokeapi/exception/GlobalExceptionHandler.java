package com.pokeapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// Maneja excepciones de toda la aplicación y retorna respuestas HTTP adecuadas
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PokemonNotFoundException.class)
    public ResponseEntity<String> handlePokemonNotFound(PokemonNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneral(Exception exception) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal server error: " + exception.getMessage());
    }
} 