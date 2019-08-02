package com.example.userverication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> userList;
    private RecyclerView userRV;
    private UserAdapter userAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        configUserRecyclerView();
        getUserList();
    }

    private void init() {
        userList = new ArrayList<>();
        userRV = findViewById(R.id.userRV);
        userAdapter = new UserAdapter(userList, this);
    }

    private void configUserRecyclerView() {
        userRV.setLayoutManager(new LinearLayoutManager(this));
        userRV.setAdapter(userAdapter);
    }

    private void getUserList() {
        User user1 = new User("Ruhul Amin", "ruhulcsesu@gmail.com", R.drawable.ruhul, true);
        User user2 = new User("Shakib", "shakib@gmail.com", R.drawable.shakib, true);
        User user3 = new User("Tamim", "tamim@gmail.com", R.drawable.tamim, false);
        User user4 = new User("Mohammadullah", "mohammadullah@gmail.com", R.drawable.mohammadullah, true);
        User user5 = new User("Musfiq", "musfiq@gmail.com", R.drawable.mushfiqur, true);
        User user6 = new User("Mashrafe", "mashrafe@gmail.com", R.drawable.mashrafe, false);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        userList.add(user5);
        userList.add(user6);
    }
}
