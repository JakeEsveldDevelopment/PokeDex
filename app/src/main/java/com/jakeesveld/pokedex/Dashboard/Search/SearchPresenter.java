package com.jakeesveld.pokedex.Dashboard.Search;

import com.jakeesveld.pokedex.api.PokeAPI;
import com.jakeesveld.pokedex.api.RetrofitInstance;
import com.jakeesveld.pokedex.models.Pokemon;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchPresenter implements SearchContract.Presenter{

    SearchContract.View view;
    PokeAPI api;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        api = RetrofitInstance.getInstance();
    }

    @Override
    public void getPokemonById(final int id) {
        Call<Pokemon> call = api.getById(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon requestedPokemon = response.body();
                view.updateUI(Arrays.asList(requestedPokemon));
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                view.handleSearchError("Couldn't find pokemon with id: " + id);
            }
        });
    }

    @Override
    public void getPokemonByName(final String name) {
        Call<Pokemon> call = api.getByName(name);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                Pokemon requestedPokemon = response.body();
                view.updateUI(Arrays.asList(requestedPokemon));
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable t) {
                view.handleSearchError("Couldn't find pokemon with name: " + name);
            }
        });
    }
}
