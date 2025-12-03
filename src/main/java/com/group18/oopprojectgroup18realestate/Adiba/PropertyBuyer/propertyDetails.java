package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;

public class propertyDetails implements Serializable {
    private String name;
    private String location;
    private String type;
    private Double price;
    private String size;

    public propertyDetails(String name, String location, String type, Double price, String size) {
        this.name = name;
        this.location = location;
        this.type = type;
        this.price = price;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "propertyDetails{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", size='" + size + '\'' +
                '}';
    }
}
