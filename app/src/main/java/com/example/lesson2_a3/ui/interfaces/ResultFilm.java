package com.example.lesson2_a3.ui.interfaces;

import com.example.lesson2_a3.models.Film;

public interface ResultFilm {
    void onSuccess(Film film);
    void onFailure(String errorMsg);
}
