package com.example.lesson2_a3.ui.interfaces;

import com.example.lesson2_a3.models.Film;

import java.util.List;

public interface ResultListFilm {
    void onSuccess(List<Film> films);
    void onFailure(String errorMsg);
}
