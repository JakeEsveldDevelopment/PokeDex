package com.jakeesveld.pokedex.Dashboard.Search;

import androidx.annotation.NonNull;

import com.jakeesveld.pokedex.api.PokeAPI;
import com.jakeesveld.pokedex.api.RetrofitInstance;
import com.jakeesveld.pokedex.models.Pokemon;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SearchPresenter implements SearchContract.Presenter{

    private SearchContract.View view;
    private PokeAPI api;

    public SearchPresenter(SearchContract.View view) {
        this.view = view;
        api = RetrofitInstance.getInstance();
    }

    @Override
    public void getPokemonById(final int id) {
        Call<Pokemon> call = api.getById(id);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(@NonNull Call<Pokemon> call, @NonNull Response<Pokemon> response) {
                Pokemon requestedPokemon = response.body();
                view.updateUI(Arrays.asList(requestedPokemon));
            }

            @Override
            public void onFailure(@NonNull Call<Pokemon> call, @NonNull Throwable t) {
                view.handleSearchError("Couldn't find pokemon with id: " + id);
            }
        });
    }

    @Override
    public void getPokemonByName(final String name) {
        Call<Pokemon> call = api.getByName(name);
        call.enqueue(new Callback<Pokemon>() {
            @Override
            public void onResponse(@NonNull Call<Pokemon> call, @NonNull Response<Pokemon> response) {
                Pokemon requestedPokemon = response.body();
                view.updateUI(Arrays.asList(requestedPokemon));
            }

            @Override
            public void onFailure(@NonNull Call<Pokemon> call, @NonNull Throwable t) {
                view.handleSearchError("Couldn't find pokemon with name: " + name);
            }
        });
    }

    @Override
    public void processSearch(String query) {
        try{
            int searchInt = Integer.parseInt(query);
            getPokemonById(searchInt);
        }catch(NumberFormatException e){
            getPokemonByName(query);
        }
    }
}
