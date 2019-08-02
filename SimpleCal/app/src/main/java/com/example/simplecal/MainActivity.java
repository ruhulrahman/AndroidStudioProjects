package com.example.simplecal;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.simplecal.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Double var1, var2, var3;
    private boolean add, sub, mul, div;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.firstNum.getText().toString());
                var2 = Double.parseDouble(binding.secondNum.getText().toString());
                var3 = var1+var2;
                binding.resultTv.setText(var3.toString());
            }
        });
        binding.btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.firstNum.getText().toString());
                var2 = Double.parseDouble(binding.secondNum.getText().toString());
                var3 = var1-var2;
                binding.resultTv.setText(var3.toString());
            }
        });
        binding.btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.firstNum.getText().toString());
                var2 = Double.parseDouble(binding.secondNum.getText().toString());
                var3 = var1*var2;
                binding.resultTv.setText(var3.toString());
            }
        });
        binding.btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                var1 = Double.parseDouble(binding.firstNum.getText().toString());
                var2 = Double.parseDouble(binding.secondNum.getText().toString());
                var3 = var1/var2;
                binding.resultTv.setText(var3.toString());
            }
        });
        binding.btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.firstNum.setText("");
                binding.secondNum.setText("");
                binding.resultTv.setText("");
            }
        });
    }
}
