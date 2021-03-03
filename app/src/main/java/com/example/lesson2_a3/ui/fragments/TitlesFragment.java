package com.example.lesson2_a3.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lesson2_a3.R;
import com.example.lesson2_a3.data.FilmStorage;
import com.example.lesson2_a3.models.Film;
import com.example.lesson2_a3.ui.adapter.FilmAdapter;
import com.example.lesson2_a3.ui.interfaces.ResultListFilm;
import com.example.lesson2_a3.ui.interfaces.TitleListener;

import java.util.List;

public class TitlesFragment extends Fragment implements TitleListener {
    private RecyclerView recyclerView;
    private FilmAdapter adapter;
    private NavController navController;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmAdapter(this);
        getFilms();
    }

    private void getFilms() {

        FilmStorage.getFilms(new ResultListFilm() {
            @Override
            public void onSuccess(List<Film> films) {
                Log.d("tag", films.toString());
                adapter.setList(films);
            }

            @Override
            public void onFailure(String errorMsg) {
                Log.d("tag", errorMsg);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_titles, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);

    }

    private void init(@NonNull View view) {
        recyclerView = view.findViewById(R.id.rv_film_title);
        recyclerView.addItemDecoration(new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(adapter);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);

    }

    @Override
    public void openDetails(String id) {
        navController.navigate(TitlesFragmentDirections.actionTitlesFragmentToDetailsFragment(id));
    }
}