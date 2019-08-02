package com.example.sqlitedatainsert;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.sqlitedatainsert.databinding.ActivityShowDataBinding;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {
    private ArrayList<User> users;
    private UserAdapter userAdapter;
    private ActivityShowDataBinding binding;
    private Database helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_data);


        init();
        getData();
    }

    private void init() {
        users = new ArrayList<>();
        helper = new Database(this);
        userAdapter = new UserAdapter(users, this, helper);
        binding.recyclerViewUserData.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerViewUserData.setAdapter(userAdapter);
    }

    private void getData() {
        Cursor cursor = helper.showData();
        while (cursor.moveToNext()){
            int id = cursor.getInt(cursor.getColumnIndex(helper.COL_ID));
            String name = cursor.getString(cursor.getColumnIndex(helper.COL_NAME));
            String age = cursor.getString(cursor.getColumnIndex(helper.COL_AGE));
            users.add(new User(id, name, age));
            userAdapter.notifyDataSetChanged();
        }
    }
}
