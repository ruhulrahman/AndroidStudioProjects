package com.example.studentsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button ruhul, rasel, humayun, anfal, naeem, harun, sumon, masud, jibon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        ruhul.setOnClickListener(MainActivity.this);
        rasel.setOnClickListener(MainActivity.this);
        humayun.setOnClickListener(MainActivity.this);
        anfal.setOnClickListener(MainActivity.this);
        naeem.setOnClickListener(MainActivity.this);
        harun.setOnClickListener(MainActivity.this);
        sumon.setOnClickListener(MainActivity.this);
        masud.setOnClickListener(MainActivity.this);
        jibon.setOnClickListener(MainActivity.this);
    }

    private void init() {
        ruhul = findViewById(R.id.ruhul);
        rasel = findViewById(R.id.rasel);
        humayun = findViewById(R.id.humayun);
        anfal = findViewById(R.id.anfal);
        naeem = findViewById(R.id.naeem);
        harun = findViewById(R.id.harun);
        sumon = findViewById(R.id.sumon);
        masud = findViewById(R.id.masud);
        jibon = findViewById(R.id.jibon);
    }

    public void onClick(View view){
        if(view.getId() == R.id.ruhul){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "ruhul");
            startActivity(intent);
        }

        if(view.getId() == R.id.rasel){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "rasel");
            startActivity(intent);
        }

        if(view.getId() == R.id.humayun){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "humayun");
            startActivity(intent);
        }

        if(view.getId() == R.id.anfal){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "anfal");
            startActivity(intent);
        }

        if(view.getId() == R.id.naeem){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "naeem");
            startActivity(intent);
        }

        if(view.getId() == R.id.harun){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "harun");
            startActivity(intent);
        }

        if(view.getId() == R.id.sumon){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "sumon");
            startActivity(intent);
        }

        if(view.getId() == R.id.masud){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "masud");
            startActivity(intent);
        }
        if(view.getId() == R.id.jibon){
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("name", "jibon");
            startActivity(intent);
        }
    }
}
