package com.example.sqliteinsertviewdelete;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sqliteinsertviewdelete.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private DatabaseHelper helper;
    private String name, age;
    private String updateName, updateAge, updateId;
    private int id;
    public boolean condition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        helper = new DatabaseHelper(this);
        insertData();

        getData();

    }

    private void getData() {
        updateName = getIntent().getStringExtra("name");
        updateAge = getIntent().getStringExtra("age");

        binding.nameET.setText(updateName);
        binding.ageET.setText(updateAge);
    }

    public void insertData(){
        condition = false;
        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = binding.nameET.getText().toString();
                age = binding.ageET.getText().toString();
                long id = helper.insertData(name, age);
                condition = true;
                if (condition = true){
                    binding.nameET.setText("");
                    binding.ageET.setText("");
                }
                Toast.makeText(MainActivity.this, "ID is "+id, Toast.LENGTH_SHORT).show();

            }
        });
    }


    public void showData(View view) {
        Intent intent = new Intent(MainActivity.this, ShowDataActivity.class);
        startActivity(intent);
    }

    public void updateData(View view) {
        name = binding.nameET.getText().toString();
        age = binding.ageET.getText().toString();

        updateId = getIntent().getStringExtra("id");

        id = Integer.parseInt(updateId);

        helper.updateData(id, name, age);
        Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ShowDataActivity.class);
        startActivity(intent);
    }
}
