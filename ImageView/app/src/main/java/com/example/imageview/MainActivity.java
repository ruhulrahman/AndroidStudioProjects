package com.example.imageview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String url = 'https://scontent.fdac67-1.fna.fbcdn.net/v/t1.0-9/40377618_2162050307379760_7628643395585441792_n.jpg?_nc_cat=109&_nc_oc=AQnxc-Qv4nmu2i6MSzRmf6hkJ6CqZASSH8mlTeuQQ9BLXKXlZKFwT4v8xUoDSl4CB7w&_nc_ht=scontent.fdac67-1.fna&oh=304eabb4bee987f4730b549bf84d2547&oe=5D65D486';

        imageView = (ImageView) findViewById(R.id.imageId);
        Picasso.get().load(url).into(imageView);
    }
}
