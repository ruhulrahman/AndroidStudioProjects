package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Movie> movies;
    private MovieAdapter movieAdapter;
    private RecyclerView movieRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        getMovies();
        configRecyclerView();
    }

    private void init() {
        movies = new ArrayList<>();
        movieRV = findViewById(R.id.movieRV);
        movieAdapter = new MovieAdapter(movies, this);

    }

    private void getMovies() {
        Movie movie1 = new Movie("Avengers: Endgame", "Anthony Russo", R.drawable.avengers);
        Movie movie2 = new Movie("Captain Marvel", "Anna Boden", R.drawable.captain_marvel);
        Movie movie3 = new Movie("Shazam!", "David F. Sandberg", R.drawable.shazam);
        Movie movie4 = new Movie("Toy Story 4", "Josh Cooley", R.drawable.toy_story);
        Movie movie5 = new Movie("Dark Phoenix", "Simon Kinberg", R.drawable.dark_phoenix);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie4);
        movies.add(movie5);
    }

    private void configRecyclerView() {
        movieRV.setLayoutManager(new LinearLayoutManager(this));
        movieRV.setAdapter(movieAdapter);
    }
}
