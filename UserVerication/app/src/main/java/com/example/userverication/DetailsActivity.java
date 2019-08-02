package com.example.userverication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private String userName, userEmail;
    private int userImage;
    private boolean isVerified;

    private ImageView imageTv, verifiedIv;
    private TextView nameTv, emailTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        init();

        if(getIntent().getExtras() != null){
            userImage = getIntent().getExtras().getInt("image");
            userName = getIntent().getExtras().getString("name");
            userEmail = getIntent().getExtras().getString("email");
            isVerified = getIntent().getExtras().getBoolean("isVerified");

            imageTv.setImageResource(userImage);
            nameTv.setText(userName);
            emailTv.setText(userEmail);

            if(isVerified == false){
                verifiedIv.setImageResource(R.drawable.ic_do_not_disturb_on_black_24dp);
            }

        }

    }

    private void init() {
        imageTv = findViewById(R.id.imageIv);
        verifiedIv = findViewById(R.id.verifiedIv);
        nameTv = findViewById(R.id.nameTv);
        emailTv = findViewById(R.id.emailTv);
    }

    public void back(View view) {
        onBackPressed();
    }
}
