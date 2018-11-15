package com.marolix.smarttablayout.model.placeorderresponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class Order{
	@SerializedName("orderNumber")
	@Expose
	private String orderNumber;
	@SerializedName("shippingDetails")
	@Expose
	private ShippingDetails shippingDetails;
	@SerializedName("created")
	@Expose
	private String created;
	@SerializedName("__v")
	@Expose
	private int __v;
	@SerializedName("taxes")
	@Expose
	private List<Object> taxes;
	@SerializedName("_id")
	@Expose
	private String _id;
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

	public List<Object> getTaxes(){
		return taxes; 
	}

	public ShippingDetails getShippingDetails(){
		return shippingDetails; 
	}

	public void setStatus(String status){
		this.status = status; 
	}

	public void setCreated(String created){
		this.created = created; 
	}

	public UserDetails getUserDetails(){
		return userDetails; 
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products; 
	}

	public String get_id(){
		return _id; 
	}

	public void setUser(String user){
		this.user = user; 
	}

	public void setShippingDetails(ShippingDetails shippingDetails){
		this.shippingDetails = shippingDetails; 
	}

	public void set_id(String _id){
		this._id = _id; 
	}

	public List<ProductsItem> getProducts(){
		return products; 
	}

	public String getCreated(){
		return created; 
	}

	public String getUser(){
		return user; 
	}

	public void setPaymentType(String paymentType){
		this.paymentType = paymentType; 
	}

	public String getOrderNumber(){
		return orderNumber; 
	}

	public String getStatus(){
		return status; 
	}

	public void setOrderNumber(String orderNumber){
		this.orderNumber = orderNumber; 
	}

	public void setUserDetails(UserDetails userDetails){
		this.userDetails = userDetails; 
	}

	public String getPaymentType(){
		return paymentType; 
	}

	public int get__v(){
		return __v; 
	}

	public void setTaxes(List<Object> taxes){
		this.taxes = taxes; 
	}

	public void set__v(int __v){
		this.__v = __v; 
	}

}