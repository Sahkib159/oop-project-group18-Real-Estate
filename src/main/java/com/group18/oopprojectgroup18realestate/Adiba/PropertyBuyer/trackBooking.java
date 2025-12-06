package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;

public class trackBooking implements Serializable {
    private String name;
    private String propertyID;
    private String currentStatus;

    public trackBooking(String name, String propertyID, String currentStatus) {
        this.name = name;
        this.propertyID = propertyID;
        this.currentStatus = currentStatus;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    @Override
    public String toString() {
        return "trackBooking{" +
                "name='" + name + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}

