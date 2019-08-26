package com.example.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.sharedpreference.databinding.ActivityVerifyBinding;

public class VerifyActivity extends AppCompatActivity {
    private ActivityVerifyBinding binding;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private String name;
    private int age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        name = sharedPreferences.getString("name", null);
        age = sharedPreferences.getInt("age", 0);
        binding.nameTV.setText(name);
        binding.ageTV.setText(String.valueOf(age));
    }
}
