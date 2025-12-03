package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;

public class notificationAgent implements Serializable {
    private String propertyID;
    private String buyerName;
    private String writeMessage;

    public notificationAgent(String propertyID, String buyerName, String writeMessage) {
        this.propertyID = propertyID;
        this.buyerName = buyerName;
        this.writeMessage = writeMessage;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getWriteMessage() {
        return writeMessage;
    }

    public void setWriteMessage(String writeMessage) {
        this.writeMessage = writeMessage;
    }

    @Override
    public String toString() {
        return "notificationAgent{" +
                "propertyID='" + propertyID + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", writeMessage='" + writeMessage + '\'' +
                '}';
    }
}
