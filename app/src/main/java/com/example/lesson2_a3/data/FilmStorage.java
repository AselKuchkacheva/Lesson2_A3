package com.example.lesson2_a3.data;

import com.example.lesson2_a3.models.Film;
import com.example.lesson2_a3.ui.interfaces.ResultFilm;
import com.example.lesson2_a3.ui.interfaces.ResultListFilm;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmStorage {
    public static void getFilms(ResultListFilm resultListFilm) {
        RetrofitBuilder.getInstance().getFilms().enqueue(new Callback<List<Film>>() {
            @Override
            public void onResponse(Call<List<Film>> call, Response<List<Film>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    resultListFilm.onSuccess(response.body());
                } else {
                    resultListFilm.onFailure(String.valueOf(response.code()));
                }
            }
            @Override
            public void onFailure(Call<List<Film>> call, Throwable t) {
                resultListFilm.onFailure(t.getLocalizedMessage());
            }
        });
    }

    public static void getFilmID(String id, ResultFilm resultFilm) {
        RetrofitBuilder.getInstance().getFilmByID(id).enqueue(new Callback<Film>() {
            @Override
            public void onResponse(Call<Film> call, Response<Film> response) {
                if (response.isSuccessful() && response.body() != null) {
                    resultFilm.onSuccess(response.body());
                } else {
                    resultFilm.onFailure(String.valueOf(response.code()));
                }
            }

            @Override
            public void onFailure(Call<Film> call, Throwable t) {
                resultFilm.onFailure(t.getLocalizedMessage());
            }
        });
    }


}
