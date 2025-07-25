package com.pokeapi.controller;

import com.pokeapi.model.PokemonResponse;
import com.pokeapi.service.PokeApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {
    private final PokeApiService pokeApiService;

    public PokemonController(PokeApiService pokeApiService) {
        this.pokeApiService = pokeApiService;
    }

    @Operation(summary = "Get Pokémon by name", description = "Returns structured information about a Pokémon, including name, types, abilities, moves, stats, and image in base64.")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Pokémon found", content = @Content(schema = @Schema(implementation = PokemonResponse.class))),
        @ApiResponse(responseCode = "404", description = "Pokémon not found", content = @Content)
    })
    @GetMapping("/{name}")
    public PokemonResponse getPokemon(
            @Parameter(description = "Name of the Pokémon", example = "pikachu")
            @PathVariable String name) {
        return pokeApiService.getPokemonByName(name);
    }
} 