package com.marolix.smarttablayout.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class StoreProductsModel {
	@SerializedName("menuOrder")
	@Expose
	private int menuOrder;
	@SerializedName("childrens")
	@Expose
	private List<ChildrensItem> childrens;
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
	private List<Object> products;
	@SerializedName("tags")
	@Expose
	private List<Object> tags;

	public List<Object> getProducts(){
		return products;
	}

	public void setMenuOrder(int menuOrder){
		this.menuOrder = menuOrder;
	}

	public String get_id(){
		return _id;
	}

	public void setChildrens(List<ChildrensItem> childrens){
		this.childrens = childrens;
	}

	public void set_id(String _id){
		this._id = _id;
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

	public List<ChildrensItem> getChildrens(){
		return childrens;
	}

	public void setProducts(List<Object> products){
		this.products = products;
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

	public int getMenuOrder(){
		return menuOrder;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void set__v(int __v){
		this.__v = __v;
	}

}