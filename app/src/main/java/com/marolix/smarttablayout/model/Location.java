package com.marolix.smarttablayout.model;


public class Location {

    private String type;
    private String[] coordinates;
    private String formated_address;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getFormated_address() {
        return formated_address;
    }

    public void setFormated_address(String formated_address) {
        this.formated_address = formated_address;
    }
}