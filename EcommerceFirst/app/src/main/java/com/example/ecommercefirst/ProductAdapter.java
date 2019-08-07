package com.example.ecommercefirst;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayList<Product> products;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.prodoct_item_view, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        Product currentProduct = products.get(i);
        viewHolder.productNameTv.setText(currentProduct.getProductName());
        viewHolder.productPriceTv.setText(currentProduct.getProductPrice()+" Tk");
        viewHolder.productIv.setImageResource(currentProduct.getProductImage());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView productNameTv, productPriceTv;
        private ImageView productIv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTv = itemView.findViewById(R.id.productNameTv);
            productPriceTv = itemView.findViewById(R.id.productPriceTv);
            productIv = itemView.findViewById(R.id.productIV);
        }
    }
}