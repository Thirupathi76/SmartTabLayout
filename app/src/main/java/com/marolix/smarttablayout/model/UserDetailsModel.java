package com.marolix.smarttablayout.model;

import java.util.List;

public class UserDetailsModel {

    private String password;
    private List<AddressesItem> addresses;
    private String name;
    private String _id;
    private String email;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}