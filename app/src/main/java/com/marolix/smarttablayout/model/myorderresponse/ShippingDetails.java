package com.marolix.smarttablayout.model.myorderresponse;

import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ShippingDetails{
	@SerializedName("pincode")
	@Expose
	private Object pincode;
	@SerializedName("address")
	@Expose
	private String addressLine;
	@SerializedName("city")
	@Expose
	private String city;
	@SerializedName("landmark")
	@Expose
	private String landmark;

	public void setPincode(Object pincode){
		this.pincode = pincode; 
	}

	public Object getPincode(){
		return pincode; 
	}

	public String getAddress(){
		return addressLine;
	}

	public void setAddress(String address){
		this.addressLine = addressLine;
	}

	public void setLandmark(String landmark){
		this.landmark = landmark; 
	}

	public void setCity(String city){
		this.city = city; 
	}

	public String getLandmark(){
		return landmark; 
	}

	public String getCity(){
		return city; 
	}

}