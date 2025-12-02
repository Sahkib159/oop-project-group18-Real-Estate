package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;

public class PropertyRental implements Serializable {
    private int propertyID;
    private String location;
    private double rentPrice;
    private String propertyType;
    private String status;
    private double budget;

    //constructor

    public PropertyRental(int propertyID, String location, double rentPrice, String propertyType, double budget, String status) {
        this.propertyID = propertyID;
        this.location = location;
        this.rentPrice = rentPrice;
        this.propertyType = propertyType;
        this.budget = budget;
        this.status = status;
    }


    //getter & setter

    public PropertyRental(int propertyID, double budget, String status, String propertyType, double rentPrice, String location) {
        this.propertyID = propertyID;
        this.budget = budget;
        this.status = status;
        this.propertyType = propertyType;
        this.rentPrice = rentPrice;
        this.location = location;
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
                ", budget=" + budget +
                '}';
    }
}
