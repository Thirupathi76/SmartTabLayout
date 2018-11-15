package com.marolix.smarttablayout.model.orderdetails;

import android.location.Location;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class ShippingDetails{
	@SerializedName("pincode")
	@Expose
	private String pincode;
	@SerializedName("addressLine")
	@Expose
	private String addressLine;
	@SerializedName("city")
	@Expose
	private String city;
	@SerializedName("landmark")
	@Expose
	private String landmark;

	@SerializedName("location")
	@Expose
	private Location location;
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
	public void setPincode(String pincode){
		this.pincode = pincode; 
	}

	public String getPincode(){
		return pincode; 
	}

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

	public String getLandmark(){
		return landmark; 
	}

	public String getCity(){
		return city; 
	}

}