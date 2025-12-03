package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;

public class savedProperties implements Serializable {
    private String name;
    private double price;
    private String location;
    private String size;

    public savedProperties(String name, double price, String location, String size) {
        this.name = name;
        this.price = price;
        this.location = location;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "savedProperties{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", location='" + location + '\'' +
                ", size='" + size + '\'' +
                '}';
    }
}
