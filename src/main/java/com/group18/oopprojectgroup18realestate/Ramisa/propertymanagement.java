package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;

public class propertymanagement implements Serializable {
    private int PropertyID;
    private String Location;
    private double RentPrice;
    private String PropertyType;
    private String Status;
    private int Contact;
    private String facilities;

    public propertymanagement(int propertyID, String location, String propertyType, double rentPrice, String status, String facilities, int contact) {
        PropertyID = propertyID;
        Location = location;
        PropertyType = propertyType;
        RentPrice = rentPrice;
        Status = status;
        this.facilities = facilities;
        Contact = contact;
    }

    public int getPropertyID() {
        return PropertyID;
    }

    public void setPropertyID(int propertyID) {
        PropertyID = propertyID;
    }

    public double getRentPrice() {
        return RentPrice;
    }

    public void setRentPrice(double rentPrice) {
        RentPrice = rentPrice;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getPropertyType() {
        return PropertyType;
    }

    public void setPropertyType(String propertyType) {
        PropertyType = propertyType;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public int getContact() {
        return Contact;
    }

    public void setContact(int contact) {
        Contact = contact;
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
                "PropertyID=" + PropertyID +
                ", Location='" + Location + '\'' +
                ", RentPrice=" + RentPrice +
                ", PropertyType='" + PropertyType + '\'' +
                ", Status='" + Status + '\'' +
                ", Contact=" + Contact +
                ", facilities='" + facilities + '\'' +
                '}';
    }
}
