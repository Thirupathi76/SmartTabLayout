package com.marolix.smarttablayout.model;

/**
 * Created by root on 15/6/17.
 */
public class PricesModel {

    private String _id = null;

    private String region = null;

    private String amount = null;

    private String tax = null;

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }
}