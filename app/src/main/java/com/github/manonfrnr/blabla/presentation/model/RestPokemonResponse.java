package com.github.manonfrnr.blabla.presentation.model;

import java.util.List;

public class RestPokemonResponse {
    private Integer count;
    private String next;
    private List <Pokemon> results;

    public Integer getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public List<Pokemon> getResults() {
        return results;
    }
}
