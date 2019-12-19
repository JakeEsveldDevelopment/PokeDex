package com.jakeesveld.pokedex.Dashboard.Search;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.jakeesveld.pokedex.R;
import com.jakeesveld.pokedex.models.Pokemon;

import java.util.List;


public class SearchFragment extends Fragment implements SearchContract.View {

    RecyclerView recyclerView;
    EditText editSearch;
    SearchContract.Presenter presenter;

    public SearchFragment() {
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void updateUI(List<Pokemon> dataList) {

    }

    @Override
    public void handleSearchError(String message) {

    }
}
