package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;

public class propertyDetails implements Serializable {
    private String propertyID;
    private String address;
    private double price;
    private String availability;
    private String description;

    public propertyDetails(String propertyID, String address, double price, String availability, String description) {
        this.propertyID = propertyID;
        this.address = address;
        this.price = price;
        this.availability = availability;
        this.description = description;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "propertyDetails{" +
                "propertyID='" + propertyID + '\'' +
                ", address='" + address + '\'' +
                ", price=" + price +
                ", availability='" + availability + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
