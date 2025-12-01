package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;

public class PropertyRental implements Serializable {
    private int propertyID;
    private String location;
    private double rentPrice;
    private String propertyType;
    private String status;

    //constructor

    public PropertyRental(int propertyID, String location, double rentPrice, String propertyType, String status) {
        this.propertyID = propertyID;
        this.location = location;
        this.rentPrice = rentPrice;
        this.propertyType = propertyType;
        this.status = status;
    }

    //getter & setter

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getRentPrice() {
        return rentPrice;
    }

    public void setRentPrice(double rentPrice) {
        this.rentPrice = rentPrice;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    //toString

    @Override
    public String toString() {
        return "PropertyRental{" +
                "propertyID=" + propertyID +
                ", location='" + location + '\'' +
                ", rentPrice=" + rentPrice +
                ", propertyType='" + propertyType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
