package com.example.ecommerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductDetailsActivity extends AppCompatActivity {
    private TextView productNameTv, productPriceTv;
    private ImageView productIV;
    private String productName;
    private int productPrice, productImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        init();

        if(getIntent() != null){
            productName = getIntent().getExtras().getString("productName");
            productPrice = getIntent().getExtras().getInt("productPrice");
            productImage = getIntent().getExtras().getInt("productImage");

            productNameTv.setText(productName);
            productPriceTv.setText(String.valueOf(productPrice));
            productIV.setImageResource(productImage);
        }

    }

    private void init() {
        productNameTv = findViewById(R.id.productNameTv);
        productPriceTv = findViewById(R.id.productPriceTv);
        productIV = findViewById(R.id.productIV);
    }

    public void onBack(View view) {
        onBackPressed();
    }
}
