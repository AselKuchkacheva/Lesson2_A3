package com.example.lesson2_a3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.lesson2_a3.R;
import com.example.lesson2_a3.data.FilmStorage;
import com.example.lesson2_a3.models.Film;
import com.example.lesson2_a3.ui.adapter.FilmAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}