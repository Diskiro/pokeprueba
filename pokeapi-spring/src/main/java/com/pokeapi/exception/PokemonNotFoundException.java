package com.pokeapi.exception;

public class PokemonNotFoundException extends RuntimeException {
    public PokemonNotFoundException(String name) {
        super("Pokémon not found: " + name);
    }
} 