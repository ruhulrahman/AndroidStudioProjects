package com.example.clickbutton;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView Mytxt;
    TextView textResult;
    EditText basic;
    Button Mybtn;
    EditText editValue;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Mybtn = (Button) findViewById(R.id.btn);
        Mytxt = (TextView) findViewById(R.id.text);
        textResult = (TextView) findViewById(R.id.textResult);
        editValue = (EditText) findViewById(R.id.editTxt);
        //RadioButton radioMan = (RadioButton) findViewById(R.id.radio_man)


        Mybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                int basic = Integer.parseInt(editValue.getText().toString());
                int festival = basic * 2;
                int yearly_basic = basic * 12;
                int yearly_total_income = festival + yearly_basic;
                int taxtWaiver = 250000;
                if(yearly_total_income <= taxtWaiver){
                    textResult.setText("You are not eligible for income tax");
                }else {

                    int taxAbleAmount = yearly_total_income - taxtWaiver;
                    int firstSlab_4_lakh = 400000;
                    int secondSlab_5_lakh = 500000;
                    int secondSlabTax = 0;
                    double totalIncomeTax = 0;
                    double tenPercentTax = 0;
                    double fifteenPercentTax = 0;
                    double tenPercent = 0.10;
                    double fifteenPercent = 0.15;
                    double twentyFivePercent = 0.25;


                    if(taxAbleAmount >= firstSlab_4_lakh || taxAbleAmount <= firstSlab_4_lakh){
                        if(taxAbleAmount <= firstSlab_4_lakh){
                            tenPercentTax = taxAbleAmount * tenPercent;
                        }else{
                            tenPercentTax = firstSlab_4_lakh * tenPercent;
                        }

                        secondSlabTax = taxAbleAmount - firstSlab_4_lakh;

                        if(secondSlabTax > 0 && secondSlabTax <= secondSlab_5_lakh){
                            fifteenPercentTax = secondSlabTax * fifteenPercent;
                        }

                        totalIncomeTax = tenPercentTax + fifteenPercentTax;

                        double taxRebate = yearly_total_income * twentyFivePercent * fifteenPercent;
                        double actualTax = totalIncomeTax - taxRebate;


                        double payableTax;
                        if(actualTax <= 5000){
                            payableTax = 5000;
                        }else{
                            payableTax = actualTax;
                        }
                        textResult.setText("Taxable Amount "+payableTax);
                    }
                }

            }
        });
    }
}
