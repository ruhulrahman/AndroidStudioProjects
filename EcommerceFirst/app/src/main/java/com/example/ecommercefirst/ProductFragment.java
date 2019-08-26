package com.example.ecommercefirst;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProductFragment extends Fragment {
    private ArrayList<Product> products;
    private RecyclerView       productRV;
    private ProductAdapter     productAdapter;
    private Context context;

    public ProductFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_product, container, false);
        productRV = view.findViewById(R.id.productRV);


        init(view);
        getProducts();
        recyclerViewConfig();

        return view;
    }

    private void init(View view) {
        products = new ArrayList<>();
        productAdapter = new ProductAdapter(products, getContext());
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
        productRV.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        productRV.setAdapter(productAdapter);
    }




}
