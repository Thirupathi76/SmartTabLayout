package com.marolix.smarttablayout.model;

/**
 * Created by techniche-v1 on 30/9/16.
 */

public class LocationSerachModel {
    String _id;
    String storeName;
    String distance;
    String address;
    String status = null;

    String timimng = null;

    String description = null;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTimimng() {
        return timimng;
    }

    public void setTimimng(String timimng) {
        this.timimng = timimng;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
