package com.marolix.smarttablayout.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ChildrensItem{
	@SerializedName("childrens")
	@Expose
	private List<Object> childrens;
	@SerializedName("__v")
	@Expose
	private int __v;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("_id")
	@Expose
	private String _id;
	@SerializedName("status")
	@Expose
	private boolean status;
	@SerializedName("products")
	@Expose
	private List<ProductsItem> products;
	@SerializedName("tags")
	@Expose
	private List<Object> tags;

	public List<Object> getChildrens(){
		return childrens; 
	}

	public void setChildrens(List<Object> childrens){
		this.childrens = childrens; 
	}

	public void setProducts(List<ProductsItem> products){
		this.products = products; 
	}

	public String get_id(){
		return _id; 
	}

	public void set_id(String _id){
		this._id = _id; 
	}

	public List<ProductsItem> getProducts(){
		return products; 
	}

	public String getName(){
		return name; 
	}

	public boolean isStatus(){
		return status; 
	}

	public void setName(String name){
		this.name = name; 
	}

	public void setStatus(boolean status){
		this.status = status; 
	}

	public void setTags(List<Object> tags){
		this.tags = tags; 
	}

	public int get__v(){
		return __v; 
	}

	public List<Object> getTags(){
		return tags; 
	}

	public void set__v(int __v){
		this.__v = __v; 
	}

}