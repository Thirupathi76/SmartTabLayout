package com.marolix.smarttablayout.model;

/**
 * Created by goutam on 22/9/16.
 */
public class CartCounterModel {

    int productCount;
    Product product;

    @Override
    public String toString() {
        return "{" +
                "productCount=" + productCount +
                ", product=" + product.getId() +
                '}';
    }

    public int getProductCount() {
        return productCount;
    }

    public void setProductCount(int productCount) {
        this.productCount = productCount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}