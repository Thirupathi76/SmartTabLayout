package com.marolix.smarttablayout.model.myorderresponse;

import com.google.gson.annotations.Expose;
import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("com.robohorse.robopojogenerator")
public class UserDetails{
	@SerializedName("phone")
	@Expose
	private String phone;
	@SerializedName("name")
	@Expose
	private String name;
	@SerializedName("email")
	@Expose
	private String email;

	public void setPhone(String phone){
		this.phone = phone; 
	}

	public String getPhone(){
		return phone; 
	}

	public String getEmail(){
		return email; 
	}

	public String getName(){
		return name; 
	}

	public void setEmail(String email){
		this.email = email; 
	}

	public void setName(String name){
		this.name = name; 
	}

}