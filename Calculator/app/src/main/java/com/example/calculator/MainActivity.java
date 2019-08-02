package com.example.calculator;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.example.calculator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Double var1, var2;
    private boolean add, sub, mul, div;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"0");
            }
        });
        binding.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"1");
            }
        });
        binding.btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"2");
            }
        });
        binding.btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"3");
            }
        });
        binding.btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"4");
            }
        });
        binding.btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"5");
            }
        });
        binding.btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"6");
            }
        });
        binding.btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"7");
            }
        });
        binding.btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"8");
            }
        });
        binding.btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"9");
            }
        });
        binding.btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+".");
            }
        });
        binding.btnPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(binding.inputTv.getText()+"%");
            }
        });
        binding.btnAc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.inputTv.setText(null);
            }
        });
        binding.btnDivided.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.inputTv.getText()+"");
                div = true;
                binding.inputTv.setText(null);
            }
        });
        binding.btnMultiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.inputTv.getText()+"");
                mul = true;
                binding.inputTv.setText(null);
            }
        });
        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.inputTv.getText()+"");
                add = true;
                binding.inputTv.setText(null);
            }
        });
        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.inputTv.getText()+"");
                sub = true;
                binding.inputTv.setText(null);
            }
        });

        //Calculation here-------------
        binding.btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var2 = Double.parseDouble(binding.inputTv.getText()+"");
                if (add == true) {
                    binding.inputTv.setText((var1 + var2) + "");
                    add = false;
                }
                if(sub == true){
                    binding.inputTv.setText((var1 - var2)+"");
                    sub = false;
                }
                if(mul == true){
                    binding.inputTv.setText((var1 * var2)+"");
                    mul = false;
                }
                if(div == true){
                    binding.inputTv.setText((var1 / var2)+"");
                    div = false;
                }
            }
        });
    }


}
