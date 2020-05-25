package com.github.manonfrnr.blabla.presentation.controller;

import android.content.SharedPreferences;

import com.github.manonfrnr.blabla.Singletons;
import com.github.manonfrnr.blabla.presentation.model.Pokemon;
import com.github.manonfrnr.blabla.presentation.model.RestPokemonDetailResponse;
import com.github.manonfrnr.blabla.presentation.view.DetailActivity;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailController {
    private DetailActivity view;
    private Gson gson;
    private SharedPreferences sharedPreferences;
    private Pokemon pokemon;

    public DetailController(DetailActivity view, Gson gson, SharedPreferences sharedPreferences, Pokemon pokemon) {
        this.view = view;
        this.gson = gson;
        this.sharedPreferences = sharedPreferences;
        this.pokemon = pokemon;
    }

    public void onStart() {
        makeApiCall();
    }

    private void makeApiCall() {
        Call<RestPokemonDetailResponse> call = Singletons.getPokeDetailApi().getPokemonDetailResponse(pokemon.getName());
        call.enqueue(new Callback<RestPokemonDetailResponse>() {
            @Override
            public void onResponse(Call<RestPokemonDetailResponse> call, Response<RestPokemonDetailResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                   pokemon.setHeight(response.body().getHeight());
                   pokemon.setWeight(response.body().getWeight());
                   view.showDetail(pokemon);
                } else {
                    view.showError();
                }
            }

            @Override
            public void onFailure(Call<RestPokemonDetailResponse> call, Throwable t) {
                view.showError();
            }
        });
    }

}
