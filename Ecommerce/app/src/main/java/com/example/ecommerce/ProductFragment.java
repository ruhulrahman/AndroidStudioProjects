package com.example.ecommerce;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ecommerce.databinding.FragmentProductBinding;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {
    private FragmentProductBinding binding;
    private ArrayList<Product> products;
    private ProductAdapter productAdapter;
    private Context context;

    public ProductFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_product, container, false);

        init(view);

        configRecyclerView();
        getProducts();


        // Inflate the layout for this fragment
        return view;
    }

    private void init(View view) {
        products = new ArrayList<>();
        productAdapter = new ProductAdapter(products);
    }

    private void configRecyclerView() {
        binding.productRV.setLayoutManager(new GridLayoutManager(context,2));
        binding.productRV.setAdapter(productAdapter);
    }

    private void getProducts() {
        Product product1 = new Product("Camera", "001", 2500, R.drawable.camera);
        Product product2 = new Product("Camera 1", "003", 2600, R.drawable.camera1);
        Product product3 = new Product("Laptop", "002", 2700, R.drawable.laptop);
        Product product4 = new Product("Laptop 1", "004", 5000, R.drawable.laptop1);
        Product product5 = new Product("Phone", "005", 6000, R.drawable.phone);

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
