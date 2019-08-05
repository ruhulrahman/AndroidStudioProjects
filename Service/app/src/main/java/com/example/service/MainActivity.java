package com.example.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startService(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(MainActivity.this, MyService.class);
        stopService(intent);
    }
}
