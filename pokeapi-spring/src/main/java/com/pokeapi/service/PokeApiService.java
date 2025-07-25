package com.pokeapi.service;

import com.pokeapi.exception.PokemonNotFoundException;
import com.pokeapi.model.PokemonResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.Base64;
import java.util.List;

@Service 
public class PokeApiService {
    private final WebClient webClient;

    public PokeApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://pokeapi.co/api/v2").build();
    }

    public PokemonResponse getPokemonByName(String name) {
        try {
            var pokeMono = webClient.get()
                    .uri("/pokemon/" + name.toLowerCase())
                    .retrieve()
                    .bodyToMono(PokeApiRaw.class)
                    .block();
            if (pokeMono == null) throw new PokemonNotFoundException(name);

            PokemonResponse response = new PokemonResponse();
            response.setName(pokeMono.name);
            response.setTypes(pokeMono.types.stream().map(t -> t.type.name).toList());
            response.setAbilities(pokeMono.abilities.stream().map(a -> a.ability.name).toList());
            response.setMoves(pokeMono.moves.stream().limit(15).map(m -> m.move.name).toList());
            response.setStats(pokeMono.stats.stream().map(s -> new PokemonResponse.Stat(s.stat.name, s.base_stat)).toList());
            response.setImageBase64(fetchImageAsBase64(pokeMono.sprites.front_default));
            return response;
        } catch (WebClientResponseException.NotFound e) {
            throw new PokemonNotFoundException(name);
        } catch (Exception e) {
            throw e;
        }
    }

    private String fetchImageAsBase64(String imageUrl) {
        if (imageUrl == null) return null;
        try {
            byte[] imageBytes = webClient.get().uri(imageUrl).retrieve().bodyToMono(byte[].class).block();
            return Base64.getEncoder().encodeToString(imageBytes);
        } catch (Exception e) {
            return null;
        }
    }

    private static class PokeApiRaw {
        public String name;
        public List<TypeSlot> types;
        public List<AbilitySlot> abilities;
        public List<MoveSlot> moves;
        public List<StatSlot> stats;
        public Sprites sprites;
    }
    private static class TypeSlot { public Type type; }
    private static class Type { public String name; }
    private static class AbilitySlot { public Ability ability; }
    private static class Ability { public String name; }
    private static class MoveSlot { public Move move; }
    private static class Move { public String name; }
    private static class StatSlot { public Stat stat; public int base_stat; }
    private static class Stat { public String name; }
    private static class Sprites { public String front_default; }
} 