package com.example.sqliteinsertviewdelete;

import android.database.Cursor;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.example.sqliteinsertviewdelete.databinding.ActivityShowDataBinding;

import java.util.ArrayList;

public class ShowDataActivity extends AppCompatActivity {
    private ArrayList<User> users;
    private DatabaseHelper helper;
    private UserAdapter userAdapter;
    private ActivityShowDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_show_data);

        users = new ArrayList<>();
        helper = new DatabaseHelper(this);
        userAdapter = new UserAdapter(users, helper, this);
        binding.userRV.setLayoutManager(new LinearLayoutManager(this));
        binding.userRV.setAdapter(userAdapter);

        getData();
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
