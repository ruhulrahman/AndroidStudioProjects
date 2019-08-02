package com.example.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView productsRV;
    private ArrayList<Product> products;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        configRecyclerView();
        getProducts();
    }

    private void init() {
        products = new ArrayList<>();
        productsRV = findViewById(R.id.productsRV);
        productAdapter = new ProductAdapter(products);

    }

    private void configRecyclerView() {
        productsRV.setLayoutManager(new GridLayoutManager(this,2));
        productsRV.setAdapter(productAdapter);
    }

    private void getProducts() {
        Product product1 = new Product("Black Pant", "001", 2500, R.drawable.pant);
        Product product2 = new Product("Pant", "003", 2600, R.drawable.pant);
        Product product3 = new Product("Ladies Top 1", "002", 2700, R.drawable.top1);
        Product product4 = new Product("Ladies Top 2", "004", 5000, R.drawable.top2);
        Product product5 = new Product("Ladies Top 3", "005", 6000, R.drawable.top3);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
    }


}
