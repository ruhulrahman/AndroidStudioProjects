package com.example.movielist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private ImageView movieImageTV;
    private TextView movieNameTV, directorNameTV;
    private String movieName, directorName;
    private int movieImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();
        if(getIntent().getExtras() != null){
            movieName = getIntent().getStringExtra("movieName");
            directorName = getIntent().getStringExtra("directorName");
            movieImage = getIntent().getIntExtra("movieImage", 0);

            movieImageTV.setImageResource(movieImage);
            movieNameTV.setText(movieName);
            directorNameTV.setText(directorName);
        }
    }

    private void init() {
        movieImageTV = findViewById(R.id.movieImageTV);
        movieNameTV = findViewById(R.id.movieNameTV);
        directorNameTV = findViewById(R.id.directorNameTV);
    }

    public void back(View view) {
        onBackPressed();
    }
}
