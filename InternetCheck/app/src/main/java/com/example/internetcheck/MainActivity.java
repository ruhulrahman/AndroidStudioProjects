package com.example.internetcheck;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private CheckInternet checkInternet = new CheckInternet();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter intentFilter = new IntentFilter();
        registerReceiver(checkInternet, intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(checkInternet);
    }
}
