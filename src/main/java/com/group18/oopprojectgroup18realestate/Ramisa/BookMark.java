package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;
import java.time.LocalDate;

public class BookMark implements Serializable {
    private int bookmarkID;
    private int tenantID;
    private int propertyID;
    private LocalDate savedDate;
    private String location;
    private double rentPrice;
    private String propertyType;

    public BookMark(int tenantID, int bookmarkID, int propertyID, LocalDate savedDate, String location, double rentPrice, String propertyType) {
        this.tenantID = tenantID;
        this.bookmarkID = bookmarkID;
        this.propertyID = propertyID;
        this.savedDate = savedDate;
        this.location = location;
        this.rentPrice = rentPrice;
        this.propertyType = propertyType;
    }

    public int getBookmarkID() {
        return bookmarkID;
    }

    public void setBookmarkID(int bookmarkID) {
        this.bookmarkID = bookmarkID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public LocalDate getSavedDate() {
        return savedDate;
    }

    public void setSavedDate(LocalDate savedDate) {
        this.savedDate = savedDate;
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

    @Override
    public String toString() {
        return "BookMark{" +
                "bookmarkID=" + bookmarkID +
                ", tenantID=" + tenantID +
                ", propertyID=" + propertyID +
                ", savedDate=" + savedDate +
                ", location='" + location + '\'' +
                ", rentPrice=" + rentPrice +
                ", propertyType='" + propertyType + '\'' +
                '}';
    }
}
