package com.example.recyclerviewlabtest;

public class Movie {
    private String movieName, directorName;
    private int movieImage;

    public Movie() {
    }

    public Movie(String movieName, String directorName, int movieImage) {
        this.movieName = movieName;
        this.directorName = directorName;
        this.movieImage = movieImage;
    }

    public String getMovieName() {
        return movieName;
    }

    public String getDirectorName() {
        return directorName;
    }

    public int getMovieImage() {
        return movieImage;
    }
}
