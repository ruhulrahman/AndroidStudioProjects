package com.example.labtestrecyclerview;

public class Movie {
    private String movieName, derectorName;
    private int movieImage;

    public Movie() {
    }

    public Movie(String movieName, String derectorName, int movieImage) {
        this.movieName = movieName;
        this.derectorName = derectorName;
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDerectorName() {
        return derectorName;
    }

    public int getMovieImage() {
        return movieImage;
    }
}
