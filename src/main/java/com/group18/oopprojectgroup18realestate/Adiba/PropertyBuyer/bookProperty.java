package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;

public class bookProperty implements Serializable {
    private String name;
    private String contact;
    private String propertyID;
    private String paymentPlan;

    public bookProperty(String name, String contact, String propertyID, String paymentPlan) {
        this.name = name;
        this.contact = contact;
        this.propertyID = propertyID;
        this.paymentPlan = paymentPlan;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getPaymentPlan() {
        return paymentPlan;
    }

    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

    @Override
    public String toString() {
        return "bookProperty{" +
                "name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", paymentPlan='" + paymentPlan + '\'' +
                '}';
    }
}
