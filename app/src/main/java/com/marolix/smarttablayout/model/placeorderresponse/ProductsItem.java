package com.marolix.smarttablayout.model.placeorderresponse;

import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProductsItem{
	@SerializedName("quantity")
	@Expose
	private int quantity;
	@SerializedName("productId")
	@Expose
	private String productId;
	@SerializedName("price")
	@Expose
	private int price;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("_id")
	@Expose
	private String _id;

	public void setPrice(int price){
		this.price = price; 
	}

	public void setProductId(String productId){
		this.productId = productId; 
	}

	public String get_id(){
		return _id; 
	}

	public void set_id(String _id){
		this._id = _id; 
	}

	public int getQuantity(){
		return quantity; 
	}

	public String getName(){
		return name; 
	}

	public void setQuantity(int quantity){
		this.quantity = quantity; 
	}

	public String getProductId(){
		return productId; 
	}

	public void setName(String name){
		this.name = name; 
	}

	public int getPrice(){
		return price; 
	}

}