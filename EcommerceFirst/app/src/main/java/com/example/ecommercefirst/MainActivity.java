package com.example.ecommercefirst;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_product:
                    replaceFragment(new ProductFragment());
                    return true;
                case R.id.navigation_cart:
                    replaceFragment(new CartFragment());
                    return true;
                case R.id.navigation_profile:
                    replaceFragment(new ProfileFragment());
                    return true;
            }
            return false;
        }
    };

    private void replaceFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutId, fragment).commit();
    }

    private ArrayList<Product> products;
    private RecyclerView productRV;
    private ProductAdapter productAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        
        init();
        recyclerViewConfig();
        getProducts();
    }

    private void getProducts() {
        Product product1 = new Product("Phone", "01", 2500, R.drawable.phone);
        Product product2 = new Product("iPhone", "02", 7500, R.drawable.iphone);
        Product product3 = new Product("Laptop", "03", 3500, R.drawable.laptop);
        Product product4 = new Product("Laptop 1", "04", 50000, R.drawable.laptop1);
        Product product5 = new Product("Camera", "05", 30000, R.drawable.camera);
        Product product6 = new Product("Camera 1", "06", 32000, R.drawable.camera1);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        products.add(product6);
    }

    private void recyclerViewConfig() {
        productRV.setLayoutManager(new GridLayoutManager(this, 2));
        productRV.setAdapter(productAdapter);
    }

    private void init() {
        products = new ArrayList<>();
        productRV = findViewById(R.id.itemRV);
        productAdapter = new ProductAdapter(products);
    }

}
