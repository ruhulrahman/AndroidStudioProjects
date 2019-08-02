package com.example.customizemenu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.customizemenu.databinding.ActivitySearchBinding;

public class MainActivity extends AppCompatActivity {
    private ActivitySearchBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.searchId){
            Intent intent = new Intent(this, SearchActivity.class);
            startActivity(intent);
        }else if(item.getItemId() == R.id.settingsId){
            Toast.makeText(this, "Settings Menu", Toast.LENGTH_SHORT).show();
        }else if(item.getItemId() == R.id.notificationId){
            Toast.makeText(this, "Notifications Menu", Toast.LENGTH_SHORT).show();
        }
        return false;
    }
}
