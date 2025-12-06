package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;

public class addNewProperty implements Serializable {
    private String propertyId;
    private String buyerName;
    private String price;
    private String size;
    private String location;
    private String availability;
    private String features;

    public addNewProperty(String propertyId, String buyerName, String price, String size, String location, String availability, String features) {
        this.propertyId = propertyId;
        this.buyerName = buyerName;
        this.price = price;
        this.size = size;
        this.location = location;
        this.availability = availability;
        this.features = features;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "addNewProperty{" +
                "propertyId='" + propertyId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", location='" + location + '\'' +
                ", availability='" + availability + '\'' +
                ", features='" + features + '\'' +
                '}';
    }
}
