package com.example.ecommercefirst;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ItemDetailsActivity extends AppCompatActivity {
    private TextView productNameTv, productPriceTv;
    private ImageView productIV;
    private int image, price;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);
        init();

        if(getIntent().getExtras() != null){
            image = getIntent().getExtras().getInt("image");
            name = getIntent().getExtras().getString("name");
            price = getIntent().getExtras().getInt("price");

            productIV.setImageResource(image);
            productNameTv.setText(name);
            productPriceTv.setText(String.valueOf(price));
        }
    }

    private void init() {
        productIV = findViewById(R.id.productIV);
        productNameTv = findViewById(R.id.productNameTv);
        productPriceTv = findViewById(R.id.productPriceTv);
    }
}
