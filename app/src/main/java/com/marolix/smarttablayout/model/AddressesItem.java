package com.marolix.smarttablayout.model;


public class AddressesItem {

    private String addressLine;
    private String city;
    private String pincode;
    private String mobile;
    private String name;
    private String _id;
    private Location location;

    @Override
    public String toString() {
        return "AddressesItem{" +
                "addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", city='" + city + '\'' +
                ", pincode='" + pincode + '\'' +
                ", mobile='" + mobile + '\'' +
                ", name='" + name + '\'' +
                ", _id='" + _id + '\'' +
                ", location=" + location +
                ", type='" + type + '\'' +
                ", landmark='" + landmark + '\'' +
                '}';
    }

    private String type;
    private String landmark;

    public String getAddress() {
        return addressLine;
    }

    public void setAddress(String address) {
        this.addressLine = address;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getPincode() {
        return pincode;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}