package com.example.demoapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    Button Mybtn;
    EditText EditButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mybtn = (Button) findViewById(R.id.btn);
        EditButton = (EditText) findViewById(R.id.editBtn);


        Mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 float c = ((5/9) * EditButton) - 32;
            }
        });

    }

}
