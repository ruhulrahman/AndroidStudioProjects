package com.example.ecommercefirst;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private ArrayList<Product> products;
    private Context context;

    public ProductAdapter(ArrayList<Product> products, Context context) {
        this.products = products;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Product currentProduct = products.get(position);
        holder.productImage.setImageResource(currentProduct.getProductImage());
        holder.productNameTv.setText(currentProduct.getProductName());
        holder.productPriceTv.setText(String.valueOf(currentProduct.getProductPrice()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ItemDetailsActivity.class);
                intent.putExtra("image", currentProduct.getProductImage());
                intent.putExtra("name", currentProduct.getProductName());
                intent.putExtra("price", currentProduct.getProductPrice());
                context.startActivity(intent);
            }
        });
        Product product = products.get(position);
        holder.productNameTv.setText(product.getProductName());
        holder.productPriceTv.setText(String.valueOf(product.getProductPrice()));
        holder.productImage.setImageResource(product.getProductImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productImage;
        private TextView productNameTv, productPriceTv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productImage = itemView.findViewById(R.id.productImage);
            productNameTv = itemView.findViewById(R.id.productNameTv);
            productPriceTv = itemView.findViewById(R.id.productPriceTv);
        }
    }
}
