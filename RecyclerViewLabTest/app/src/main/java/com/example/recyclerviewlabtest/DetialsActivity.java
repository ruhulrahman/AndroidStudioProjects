package com.example.recyclerviewlabtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetialsActivity extends AppCompatActivity {
    private TextView movieNameTV, directorNameTV;
    private ImageView movieIV;
    private String movieName, directorName;
    private int movieImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detials);
        init();
        if(getIntent().getExtras() != null){
            movieName = getIntent().getExtras().getString("movieName");
            directorName = getIntent().getExtras().getString("directorName");
            movieImage = getIntent().getExtras().getInt("movieImage");

            movieNameTV.setText(movieName);
            directorNameTV.setText(directorName);
            movieIV.setImageResource(movieImage);
        }

    }

    private void init() {
        movieNameTV = findViewById(R.id.movieNameTV);
        directorNameTV = findViewById(R.id.directorNameTV);
        movieIV = findViewById(R.id.movieIV);
    }
}
