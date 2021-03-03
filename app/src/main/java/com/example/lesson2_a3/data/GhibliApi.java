package com.example.lesson2_a3.data;

import com.example.lesson2_a3.models.Film;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GhibliApi {

    @GET("films")
    Call<List<Film>> getFilms();

    @GET("films/{id}")
    Call<Film> getFilmByID(
            @Path("id") String id
    );


}
