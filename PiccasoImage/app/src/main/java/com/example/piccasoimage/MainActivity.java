package com.example.piccasoimage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageId);
        String url = "https://scontent.fdac67-1.fna.fbcdn.net/v/t1.0-9/44628812_2190043421247115_6400905205654749184_n.jpg?_nc_cat=100&_nc_oc=AQk6jNwAuoRd-sF51xrihMg2xyM3vfczEPrQQJ5A66yXSNSoNpzrJpnzpNEF8uS3jw8&_nc_ht=scontent.fdac67-1.fna&oh=23d419e802123be839fa7d43752a9706&oe=5D5D6B38";
        Picasso.get().load(url).into(imageView);
    }
}
