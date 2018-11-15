package com.marolix.smarttablayout.model;


public class UserDetails{

	private String phone;
	private String name;
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