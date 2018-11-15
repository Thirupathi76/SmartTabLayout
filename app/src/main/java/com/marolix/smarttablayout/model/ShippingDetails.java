package com.marolix.smarttablayout.model;


public class ShippingDetails{
	private int pincode;
	private String addressLine;
	private String city;
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