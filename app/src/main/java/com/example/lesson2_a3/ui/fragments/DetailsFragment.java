package com.example.lesson2_a3.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lesson2_a3.R;
import com.example.lesson2_a3.data.FilmStorage;
import com.example.lesson2_a3.models.Film;
import com.example.lesson2_a3.ui.interfaces.ResultFilm;

public class DetailsFragment extends Fragment {
    private TextView tvDescription;
    private TextView tvTitle;
    private TextView tvDirector;
    private TextView tvProducer;
    private TextView tvReleaseDate;

    private void getFilmID(String id) {
        FilmStorage.getFilmID(id, new ResultFilm() {
            @Override
            public void onSuccess(Film film) {
                tvTitle.setText(film.getTitle());
                tvDescription.setText(film.getDescription());
                tvDirector.setText(film.getDirector());
                tvProducer.setText(film.getProducer());
                tvReleaseDate.setText(film.getReleaseDate());
            }

            @Override
            public void onFailure(String errorMsg) {

            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvTitle = view.findViewById(R.id.tv_title);
        tvDescription = view.findViewById(R.id.tv_description);
        tvDirector = view.findViewById(R.id.tv_director);
        tvProducer = view.findViewById(R.id.tv_producer);
        tvReleaseDate = view.findViewById(R.id.tv_releaseDate);
        getFilmID(DetailsFragmentArgs.fromBundle(getArguments()).getId());
    }
}