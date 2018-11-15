package com.marolix.smarttablayout.model;

import java.util.List;

public class DeliveryAddressResponseModel {

    private String message;
    private List<AddressesItem> addresses;
    private double phone;
    private String provider;
    private String created;
    private List<String> roles;
    private int __v;
    private String name;
    private String _id;
    private String email;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCreated() {
        return created;
    }

    public void setAddresses(List<AddressesItem> addresses) {
        this.addresses = addresses;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressesItem> getAddresses() {
        return addresses;
    }

    public double getPhone() {
        return phone;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setPhone(double phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public int get__v() {
        return __v;
    }

    public String getProvider() {
        return provider;
    }

    public void set__v(int __v) {
        this.__v = __v;
    }

}