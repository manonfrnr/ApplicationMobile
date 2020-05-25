package com.github.manonfrnr.blabla.presentation.model;

import java.util.List;

public class RestPokemonDetailResponse {
    private Pokemon pokemon;
    private int weight;
    private int height;

    public Pokemon getPokemon() {
            return pokemon;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }
}