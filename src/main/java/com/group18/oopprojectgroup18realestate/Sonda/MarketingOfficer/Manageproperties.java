package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

public class Manageproperties {
    private String propertyID;
    private String propertyName;
    private double price;
    private String type;
    private String status;

    public Manageproperties(String propertyID, String propertyName, double price, String type, String status) {
        this.propertyID = propertyID;
        this.propertyName = propertyName;
        this.price = price;
        this.type = type;
        this.status = status;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Manageproperties{" +
                "propertyID='" + propertyID + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
