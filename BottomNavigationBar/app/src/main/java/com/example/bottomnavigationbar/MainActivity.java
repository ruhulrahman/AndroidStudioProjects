package com.example.bottomnavigationbar;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private FrameLayout frameLayoutId;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    replaceFragment(new HomeFragment());
                    return true;
                case R.id.navigation_dashboard:
                    replaceFragment(new DashboarFragment());
                    return true;
                case R.id.navigation_notifications:
                    replaceFragment(new NotificationFragment());
                    return true;
            }
            return false;
        }
    };

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutId, fragment).commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        replaceFragment(new HomeFragment());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        frameLayoutId = findViewById(R.id.frameLayoutId);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
