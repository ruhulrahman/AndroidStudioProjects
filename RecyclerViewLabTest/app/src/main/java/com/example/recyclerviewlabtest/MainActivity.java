package com.example.recyclerviewlabtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Adapter;

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
        configRecyclerView();
        getMovies();

    }


    private void getMovies() {
        Movie movie1 = new Movie("Avengers: Endgame", "Anthony Russo", R.drawable.avengers);
        Movie movie2 = new Movie("Captain Marvel ", "Anna", R.drawable.captain);
        Movie movie3 = new Movie("shalom", "David", R.drawable.shazam);


        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
        movies.add(movie1);
        movies.add(movie2);
        movies.add(movie3);
    }

    private void init() {
        movies = new ArrayList<>();
        movieRV = findViewById(R.id.movieRV);
        movieAdapter = new MovieAdapter(movies, this);

    }


    private void configRecyclerView() {
        movieRV.setLayoutManager(new LinearLayoutManager(this));
        movieRV.setAdapter(movieAdapter);
    }
}
