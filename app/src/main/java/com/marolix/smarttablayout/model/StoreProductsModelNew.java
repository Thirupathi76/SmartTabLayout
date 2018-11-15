package com.marolix.smarttablayout.model;

import java.util.List;

/**
 * Created by root on 21/6/17.
 */
public class StoreProductsModelNew {

    private List<Object> tags;

    private String _id;

    private String status;

    private String name;

    private String __v;

    private String menuOrder;

    private String type;

    private List<Object> products;

    private List<ChildrensItem> childrens;

    public List<Object> getTags() {
        return tags;
    }

    public void setTags(List<Object> tags) {
        this.tags = tags;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String get__v() {
        return __v;
    }

    public void set__v(String __v) {
        this.__v = __v;
    }

    public String getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(String menuOrder) {
        this.menuOrder = menuOrder;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Object> getProducts() {
        return products;
    }

    public void setProducts(List<Object> products) {
        this.products = products;
    }

    public List<ChildrensItem> getChildrens() {
        return childrens;
    }

    public void setChildrens(List<ChildrensItem> childrens) {
        this.childrens = childrens;
    }
}