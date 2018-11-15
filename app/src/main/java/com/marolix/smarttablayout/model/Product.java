package com.marolix.smarttablayout.model;

/**
 * @author Pranav J.Dev E-mail : pranav@techniche.co
 *         Date : 17/8/16
 *         Module : AdyarAnandaBhavan.
 */
public class Product {

    private String id = null;

    private String name = null;

    /*private String price = null;*/

    private String count = null;

    private int code = 0;

    private int totalItems = 0;

    private PricesModel pricesModel;

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    private String imageUrl = null;

    private String unit = null;

    private String tax = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }*/

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public PricesModel getPricesModel() {
        return pricesModel;
    }

    public void setPricesModel(PricesModel pricesModel) {
        this.pricesModel = pricesModel;
    }

    public Product(String id, String name, String price, String count, String imageUrl) {
        this.id = id;
        this.name = name;
        /*this.price = price;*/
        this.count = count;
        this.imageUrl = imageUrl;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", totalItems=" + totalItems +
                '}';
    }
}