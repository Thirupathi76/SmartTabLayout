package com.marolix.smarttablayout.model.orderdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")

public class ProductsItem {

    @SerializedName("amount")
    @Expose
    private int amount;

    @SerializedName("code")
    @Expose
    private int code;
    @SerializedName("regions")
    @Expose
    private List<Object> regions;
    @SerializedName("stores")
    @Expose
    private List<Object> stores;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("tags")
    @Expose
    private List<Object> tags;
    @SerializedName("activeStatus")
    @Expose
    private boolean activeStatus;
    @SerializedName("price")
    @Expose
    private int price;
    @SerializedName("quantityHandling")
    @Expose
    private String quantityHandling;
    @SerializedName("__v")
    @Expose
    private int __v;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @SerializedName("quantity")
    @Expose
    private int quantity;

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("stockStatus")
    @Expose
    private boolean stockStatus;
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("region")
    @Expose
    private List<String> region;
    @SerializedName("stock")
    @Expose
    private int stock;
    @SerializedName("promotional")
    @Expose
    private boolean promotional;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("unit")
    @Expose
    private String unit;

    @SerializedName("tax")
    @Expose
    private String tax;

    public String get_id() {
        return _id;
    }

    public String getName() {
        return name;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public List<String> getRegion() {
        return region;
    }

    public void setRegions(List<Object> regions) {
        this.regions = regions;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public boolean isPromotional() {
        return promotional;
    }

    public int get__v() {
        return __v;
    }

    public String getDescription() {
        return description;
    }

    public int getPrice() {
        return price;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public List<Object> getRegions() {
        return regions;
    }

    public boolean isStockStatus() {
        return stockStatus;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public boolean isActiveStatus() {
        return activeStatus;
    }

    public void setQuantityHandling(String quantityHandling) {
        this.quantityHandling = quantityHandling;
    }

    public void setStockStatus(boolean stockStatus) {
        this.stockStatus = stockStatus;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setPromotional(boolean promotional) {
        this.promotional = promotional;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public List<Object> getStores() {
        return stores;
    }

    public String getQuantityHandling() {
        return quantityHandling;
    }

    public void setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
    }

    public void setRegion(List<String> region) {
        this.region = region;
    }

    public void setStores(List<Object> stores) {
        this.stores = stores;
    }

    public List<Object> getTags() {
        return tags;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

}