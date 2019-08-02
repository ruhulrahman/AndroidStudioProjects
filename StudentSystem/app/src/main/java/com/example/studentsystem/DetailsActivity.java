package com.example.studentsystem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {
    private ImageView profilePic;
    private TextView name;
    private TextView details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        init();
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String myValue = bundle.getString("name");
            showResult(myValue);
        }

    }

    private void showResult(String myValue) {

        if(myValue.equals("ruhul")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.ruhul_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("rasel")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.rasel_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("harun")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.harun_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("naeem")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.naeem_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("anfal")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.anfal_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("sumon")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.sumon_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("masud")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.masud_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("humayun")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.humayun_name);
            details.setText(R.string.details);
        }

        if(myValue.equals("jibon")){
            profilePic.setImageResource(R.drawable.ruhul);
            name.setText(R.string.jibon_name);
            details.setText(R.string.details);
        }
    }

    private void init() {
        profilePic = findViewById(R.id.profilePicIv);
        name = findViewById(R.id.nameTv);
        details = findViewById(R.id.detailsTv);
    }
}
