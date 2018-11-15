package com.marolix.smarttablayout.model.myorderresponse;

import java.util.List;
import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ProductId{

	@SerializedName("image")
	@Expose
	private String image;

	@SerializedName("code")
	@Expose
	private int code;

	@SerializedName("regions")
	@Expose
	private List<String> regions;

	@SerializedName("created")
	@Expose
	private String created;

	@SerializedName("stores")
	@Expose
	private List<Object> stores;

	@SerializedName("taxPercentage")
	@Expose
	private int taxPercentage;

	@SerializedName("description")
	@Expose
	private String description;

	@SerializedName("tags")
	@Expose
	private List<Object> tags;

	@SerializedName("unit")
	@Expose
	private String unit;

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
	private int V;

	@SerializedName("name")
	@Expose
	private String name;

	@SerializedName("stockStatus")
	@Expose
	private boolean stockStatus;

	@SerializedName("_id")
	@Expose
	private String id;

	@SerializedName("stock")
	@Expose
	private int stock;

	@SerializedName("region")
	@Expose
	private List<String> region;

	@SerializedName("promotional")
	@Expose
	private boolean promotional;

	@SerializedName("status")
	@Expose
	private String status;

	public void setImage(String image){
		this.image = image;
	}

	public String getImage(){
		return image;
	}

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setRegions(List<String> regions){
		this.regions = regions;
	}

	public List<String> getRegions(){
		return regions;
	}

	public void setCreated(String created){
		this.created = created;
	}

	public String getCreated(){
		return created;
	}

	public void setStores(List<Object> stores){
		this.stores = stores;
	}

	public List<Object> getStores(){
		return stores;
	}

	public void setTaxPercentage(int taxPercentage){
		this.taxPercentage = taxPercentage;
	}

	public int getTaxPercentage(){
		return taxPercentage;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setTags(List<Object> tags){
		this.tags = tags;
	}

	public List<Object> getTags(){
		return tags;
	}

	public void setUnit(String unit){
		this.unit = unit;
	}

	public String getUnit(){
		return unit;
	}

	public void setActiveStatus(boolean activeStatus){
		this.activeStatus = activeStatus;
	}

	public boolean isActiveStatus(){
		return activeStatus;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setQuantityHandling(String quantityHandling){
		this.quantityHandling = quantityHandling;
	}

	public String getQuantityHandling(){
		return quantityHandling;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setStockStatus(boolean stockStatus){
		this.stockStatus = stockStatus;
	}

	public boolean isStockStatus(){
		return stockStatus;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setStock(int stock){
		this.stock = stock;
	}

	public int getStock(){
		return stock;
	}

	public void setRegion(List<String> region){
		this.region = region;
	}

	public List<String> getRegion(){
		return region;
	}

	public void setPromotional(boolean promotional){
		this.promotional = promotional;
	}

	public boolean isPromotional(){
		return promotional;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}
}