package com.jakeesveld.pokedex.api;

import com.jakeesveld.pokedex.models.Pokemon;
import com.jakeesveld.pokedex.models.Type;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokeAPI {

    @GET("pokemon/{id}")
    Call<Pokemon> getById(@Path("id") int id);

    @GET("pokemon/{name}")
    Call<Pokemon> getByName(@Path("name") String name);


}
