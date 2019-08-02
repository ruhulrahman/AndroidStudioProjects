package com.example.corrency_converter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText amount;
    private String aAmount;
    private RadioButton takaTotDollar, dollarToTaka;
    private Button convert;
    private TextView result;
    private double value, finalResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        amount = (EditText) findViewById(R.id.amountET);
        takaTotDollar = (RadioButton) findViewById(R.id.takaTotDollar);
        dollarToTaka = (RadioButton) findViewById(R.id.dollarToTaka);
        convert = (Button) findViewById(R.id.convert);
        result = (TextView) findViewById(R.id.result);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aAmount = amount.getText().toString();

                if(aAmount.equals("")){
                    Toast.makeText(MainActivity.this, "You can't empty this field", Toast.LENGTH_SHORT).show();
                }else{
                    value = Double.valueOf(aAmount);

                    if(takaTotDollar.isChecked()) {
                        finalResult = value * 80;
                        result.setText(String.valueOf(finalResult+" Tk"));
                    }if (dollarToTaka.isChecked()){
                        finalResult = value / 80;
                        result.setText(String.valueOf(finalResult+" $"));
                    }
                }
            }
        });
    }
}
