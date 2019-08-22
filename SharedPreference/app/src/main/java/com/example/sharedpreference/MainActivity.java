package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.example.sharedpreference.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String name;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = binding.nameET.getText().toString();
                age = Integer.parseInt(binding.ageET.getText().toString());
                SharedPreferences.Editor editor = getSharedPreferences(name, MODE_PRIVATE).edit();
                editor.putString("name", name);
                editor.putInt("age", age);
                editor.apply();
            }
        });

    }

    public void viewData(View view) {
        startActivity(new Intent(MainActivity.this, VerifyActivity.class));
    }
}
