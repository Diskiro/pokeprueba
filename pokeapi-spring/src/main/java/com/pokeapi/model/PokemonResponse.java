package com.pokeapi.model;

import java.util.List;

public class PokemonResponse {
    private String name; 
    private List<String> types; 
    private List<String> abilities; 
    private List<String> moves; 
    private List<Stat> stats; 
    private String imageBase64; 

    public static class Stat {
        private String name;
        private int value;

        public Stat(String name, int value) {
            this.name = name;
            this.value = value;
        }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getValue() { return value; }
        public void setValue(int value) { this.value = value; }
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public List<String> getTypes() { return types; }
    public void setTypes(List<String> types) { this.types = types; }
    public List<String> getAbilities() { return abilities; }
    public void setAbilities(List<String> abilities) { this.abilities = abilities; }
    public List<String> getMoves() { return moves; }
    public void setMoves(List<String> moves) { this.moves = moves; }
    public List<Stat> getStats() { return stats; }
    public void setStats(List<Stat> stats) { this.stats = stats; }
    public String getImageBase64() { return imageBase64; }
    public void setImageBase64(String imageBase64) { this.imageBase64 = imageBase64; }
} 