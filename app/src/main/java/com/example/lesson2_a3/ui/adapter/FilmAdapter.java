package com.example.lesson2_a3.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson2_a3.R;
import com.example.lesson2_a3.data.FilmStorage;
import com.example.lesson2_a3.models.Film;
import com.example.lesson2_a3.ui.interfaces.TitleListener;

import java.util.ArrayList;
import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.FilmHolder> {
    private final List<Film> list = new ArrayList<>();
    private TitleListener titleListener;

    public FilmAdapter(TitleListener titleListener) {
        this.titleListener = titleListener;
    }

    @NonNull
    @Override
    public FilmHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_film, parent, false);
        return new FilmHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Film> films) {
        list.addAll(films);
        notifyDataSetChanged();
    }

    class FilmHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;
        private TextView tvNumber;

        public FilmHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_film_title);
            tvNumber = itemView.findViewById(R.id.tv_pos_number);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    titleListener.openDetails(list.get(getAdapterPosition()).getId());
                }
            });
        }

        public void onBind(Film film) {
            tvTitle.setText(film.getTitle());
            tvNumber.setText((1 + getAdapterPosition()) + "");
        }
    }
}
