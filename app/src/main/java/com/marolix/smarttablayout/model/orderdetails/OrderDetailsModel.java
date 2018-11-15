package com.marolix.smarttablayout.model.orderdetails;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")

public class OrderDetailsModel {

    @SerializedName("bagTotal")
    @Expose
    private double bagTotal;

    @SerializedName("serviceTax")
    @Expose
    private double serviceTax;

    @SerializedName("couponAmount")
    @Expose
    private double couponAmount;

    @SerializedName("couponCode")
    @Expose
    private String couponCode;

    @SerializedName("subTotal")
    @Expose
    private String subTotal;

    @SerializedName("deliveryTime")
    @Expose
    private String deliveryTime;

    @SerializedName("shippingDetails")
    @Expose
    private ShippingDetails shippingDetails;

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("__v")
    @Expose
    private int __v;

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @SerializedName("total")
    @Expose
    private double total;

    @SerializedName("taxes")
    @Expose
    private List<Object> taxes;
    @SerializedName("orderNumber")
    @Expose
    private String orderNumber;
    @SerializedName("_id")
    @Expose
    private String _id;
    @SerializedName("deliveryDate")
    @Expose
    private String deliveryDate;
    @SerializedName("user")
    @Expose
    private String user;
    @SerializedName("userDetails")
    @Expose
    private UserDetails userDetails;
    @SerializedName("paymentType")
    @Expose
    private String paymentType;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("products")
    @Expose
    private List<ProductsItem> products;

    public double getBagTotal() {
        return bagTotal;
    }

    public void setBagTotal(double bagTotal) {
        this.bagTotal = bagTotal;
    }

    public double getServiceTax() {
        return serviceTax;
    }

    public void setServiceTax(double serviceTax) {
        this.serviceTax = serviceTax;
    }

    public double getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(double couponAmount) {
        this.couponAmount = couponAmount;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public String getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(String subTotal) {
        this.subTotal = subTotal;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public List<Object> getTaxes() {
        return taxes;
    }

    public String getDeliveryTime() {
        return deliveryTime;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setProducts(List<ProductsItem> products) {
        this.products = products;
    }

    public String get_id() {
        return _id;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<ProductsItem> getProducts() {
        return products;
    }

    public String getCreated() {
        return created;
    }

    public String getUser() {
        return user;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getStatus() {
        return status;
    }

    public void setDeliveryTime(String deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public int get__v() {
        return __v;
    }

    public void setTaxes(List<Object> taxes) {
        this.taxes = taxes;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}