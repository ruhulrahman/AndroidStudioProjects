package com.example.ecommerce;

public class Product {
    private String productName, productId;
    private int productPrice, productImage;

    public Product(String productName, String productId, int productPrice, int productImage) {
        this.productName = productName;
        this.productId = productId;
        this.productPrice = productPrice;
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return productId;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public int getProductImage() {
        return productImage;
    }
}
