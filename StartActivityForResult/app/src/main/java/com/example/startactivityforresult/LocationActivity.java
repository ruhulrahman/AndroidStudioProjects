package com.example.startactivityforresult;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LocationActivity extends AppCompatActivity {
    private EditText locationET;
    private Button doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        init();
        doneBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String location = locationET.getText().toString();
                if(location.equals("")){
                    locationET.setError("Enter your location");
                    locationET.requestFocus();
                }else{
                    Intent intent = new Intent();
                    intent.putExtra("location", location);
                    setResult(RESULT_OK, intent);
                    finish();
                }
            }
        });

    }

    private void init() {
        locationET = findViewById(R.id.locationET);
        doneBtn = findViewById(R.id.doneBtn);
    }
}
