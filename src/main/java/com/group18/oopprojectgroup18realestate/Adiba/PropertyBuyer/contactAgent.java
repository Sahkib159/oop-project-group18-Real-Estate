package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;
import java.time.LocalDate;

public class contactAgent implements Serializable {
    private String propertyID;
    private String yourMessage;
    private String responseMethod;


    public contactAgent(String propertyID, String yourMessage, String responseMethod) {
        this.propertyID = propertyID;
        this.yourMessage = yourMessage;
        this.responseMethod = responseMethod;

    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getYourMessage() {
        return yourMessage;
    }

    public void setYourMessage(String yourMessage) {
        this.yourMessage = yourMessage;
    }

    public String getResponseMethod() {
        return responseMethod;
    }

    public void setResponseMethod(String responseMethod) {
        this.responseMethod = responseMethod;
    }

    @Override
    public String toString() {
        return "contactAgent{" +
                "propertyID='" + propertyID + '\'' +
                ", yourMessage='" + yourMessage + '\'' +
                ", responseMethod='" + responseMethod + '\'' +
                '}';
    }
}
