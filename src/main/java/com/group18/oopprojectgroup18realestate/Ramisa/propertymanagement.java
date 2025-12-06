package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;

public class propertymanagement implements Serializable {

    private static final long serialVersionUID = 1L;

    private int propertyID;
    private String location;
    private double rentPrice;
    private String propertyType;
    private String status;
    private int contact;
    private String facilities;


    public propertymanagement(int propertyID, String location, double rentPrice,
                              String propertyType, String status,
                              int contact, String facilities) {

        this.propertyID = propertyID;
        this.location = location;
        this.rentPrice = rentPrice;
        this.propertyType = propertyType;
        this.status = status;
        this.contact = contact;
        this.facilities = facilities;
    }

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

    public int getContact() {
        return contact;
    }

    public void setContact(int contact) {
        this.contact = contact;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    @Override
    public String toString() {
        return "propertymanagement{" +
                "propertyID=" + propertyID +
                ", location='" + location + '\'' +
                ", rentPrice=" + rentPrice +
                ", propertyType='" + propertyType + '\'' +
                ", status='" + status + '\'' +
                ", contact=" + contact +
                ", facilities='" + facilities + '\'' +
                '}';
    }
}
