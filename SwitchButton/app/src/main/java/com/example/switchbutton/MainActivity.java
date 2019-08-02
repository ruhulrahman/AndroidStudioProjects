 package com.example.switchbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {

    TextView Mytext;
    Switch MySwicth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MySwicth = (Switch) findViewById(R.id.switchId);
        Mytext = (TextView) findViewById(R.id.textId);

        MySwicth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    Mytext.setText("Wifi On");
                }else{
                    Mytext.setText("Wifi Off");
                }
            }
        });

    }
}
