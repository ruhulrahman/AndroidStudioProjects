package com.example.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText amount;
    private String aAmount;
    private RadioButton takaToDollar, dollarToTaka;
    private Button convertBtn;
    private TextView resultTv;
    private double value, finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amount = (EditText) findViewById(R.id.amountEt);
        takaToDollar = (RadioButton) findViewById(R.id.takaToDollar);
        dollarToTaka = (RadioButton) findViewById(R.id.dollarToTaka);
        convertBtn = (Button) findViewById(R.id.convertBtn);
        resultTv = (TextView) findViewById(R.id.resultTv);

        convertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aAmount = amount.getText().toString();
                if(aAmount.equals("")){
                    Toast.makeText(MainActivity.this, "Please input value", Toast.LENGTH_SHORT).show();
                }else{
                    value = Double.valueOf(aAmount);
                    if (takaToDollar.isChecked()){
                        finalResult = value / 80;
                        resultTv.setText(finalResult+" $");
                    }else{
                        finalResult = value * 80;
                        resultTv.setText(finalResult+" Tk");
                    }
                }
            }
        });

    }
}
