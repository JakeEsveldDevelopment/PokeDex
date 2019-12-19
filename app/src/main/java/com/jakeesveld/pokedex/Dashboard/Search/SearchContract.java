package com.jakeesveld.pokedex.Dashboard.Search;

import com.jakeesveld.pokedex.models.Pokemon;

import java.util.List;

public interface SearchContract {

    interface View {
        void updateUI(List<Pokemon> dataList);

        void handleSearchError(String message);

    }

    interface Presenter {
        void getPokemonById(int id);

        void getPokemonByName(String name);

        void processSearch(String query);

    }
}
