package com.example.recyclerviewlabtest;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> movieList;
    private Context context;

    public MovieAdapter(ArrayList<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_movie_activity, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final Movie movie = movieList.get(i);
        viewHolder.movieNameTV.setText(movie.getDirectorName());
        viewHolder.directorNameTV.setText(movie.getDirectorName());
        viewHolder.movieIV.setImageResource(movie.getMovieImage());

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetialsActivity.class);
                intent.putExtra("movieName", movie.getMovieName());
                intent.putExtra("directorName", movie.getDirectorName());
                intent.putExtra("movieImage", movie.getMovieImage());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView movieNameTV, directorNameTV;
        private ImageView movieIV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieNameTV = itemView.findViewById(R.id.movieNameTV);
            directorNameTV = itemView.findViewById(R.id.dirctorNameTV);
            movieIV = itemView.findViewById(R.id.movieIV);
        }
    }
}
