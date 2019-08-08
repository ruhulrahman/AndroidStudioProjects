package com.example.movielist;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private ArrayList<Movie> movieList;
    private String movieName, directorName;
    private int movieImage;

    public MovieAdapter(ArrayList<Movie> movieList, Context context) {
        this.movieList = movieList;
        this.context = context;
    }

    private Context context;
    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_item_activity, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieAdapter.ViewHolder holder, int position) {
        final Movie movie = movieList.get(position);
        holder.movieNameTV.setText(movie.getMovieName());
        holder.directorNameTV.setText(movie.getDirectorName());
        holder.movieImageTV.setImageResource(movie.getMovieImage());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailsActivity.class);
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
        private ImageView movieImageTV;
        private TextView movieNameTV, directorNameTV;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImageTV = itemView.findViewById(R.id.movieImageTV);
            movieNameTV = itemView.findViewById(R.id.movieNameTV);
            directorNameTV = itemView.findViewById(R.id.directorNameTV);
        }
    }
}
