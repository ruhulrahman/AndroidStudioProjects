package com.example.startactivityforresult;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_FOR_PICKUP_RESULT = 1;
    private static final int REQUEST_CODE_FOR_DROP_RESULT = 2;
    private TextView pickUpLocation, dropLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        pickUpLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                startActivityForResult(intent, REQUEST_CODE_FOR_PICKUP_RESULT);
            }
        });

        dropLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LocationActivity.class);
                startActivityForResult(intent,REQUEST_CODE_FOR_DROP_RESULT);
            }
        });
    }

    private void init() {
        pickUpLocation = findViewById(R.id.pickUpLocationTv);
        dropLocation = findViewById(R.id.dropLocationTv);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(resultCode == RESULT_OK){
            if(requestCode == REQUEST_CODE_FOR_PICKUP_RESULT){
                String location = data.getExtras().getString("location");
                pickUpLocation.setText(location);
                Toast.makeText(this, "Pickup Location", Toast.LENGTH_SHORT).show();
            }else if(requestCode== REQUEST_CODE_FOR_DROP_RESULT){
                String location = data.getExtras().getString("location");
                dropLocation.setText(location);
                Toast.makeText(this, "Drop Location", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(this, "Back without location", Toast.LENGTH_SHORT).show();
        }
    }
}
