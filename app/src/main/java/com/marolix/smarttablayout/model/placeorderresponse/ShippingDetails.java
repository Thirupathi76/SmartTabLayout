package com.marolix.smarttablayout.model.placeorderresponse;

import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class ShippingDetails{
	@SerializedName("pincode")
	@Expose
	private int pincode;
	@SerializedName("addressLine")
	@Expose
	private String addressLine;
	@SerializedName("city")
	@Expose
	private String city;
	@SerializedName("landmark")
	@Expose
	private String landmark;

	public String getAddress(){
		return addressLine;
	}

	public void setAddress(String addressLine){
		this.addressLine = addressLine;
	}

	public void setLandmark(String landmark){
		this.landmark = landmark; 
	}

	public void setCity(String city){
		this.city = city; 
	}

	public int getPincode(){
		return pincode; 
	}

	public String getLandmark(){
		return landmark; 
	}

	public void setPincode(int pincode){
		this.pincode = pincode; 
	}

	public String getCity(){
		return city; 
	}

}