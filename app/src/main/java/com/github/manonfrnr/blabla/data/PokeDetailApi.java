package com.github.manonfrnr.blabla.data;

import com.github.manonfrnr.blabla.presentation.model.RestPokemonDetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeDetailApi {

    @GET("/api/v2/pokemon/{pokemon_name}")
    Call<RestPokemonDetailResponse> getPokemonDetailResponse(@Path(value = "pokemon_name", encoded = true) String pokemonName);

}
