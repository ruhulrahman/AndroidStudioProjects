package com.example.sqlitedatainsert;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqlitedatainsert.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private Database helper;
    private String name, age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        helper = new Database(this);

        insertData();

    }

    public void insertData(){
        binding.submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.nameET.getText().toString();
                age = binding.ageET.getText().toString();
                long id = helper.insertData(name, age);

                Toast.makeText(MainActivity.this, "ID is "+id, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showUserData(View view) {
        startActivity(new Intent(MainActivity.this,ShowDataActivity.class));
    }
}
