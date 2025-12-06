package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import com.group18.oopprojectgroup18realestate.User;

import java.io.Serializable;

public class assistduringproperty extends User implements Serializable {
    private String bookingID;
    private String customerName;
    private String customerContact;

    private String propertyID;
    private String propertyAddress;

    public assistduringproperty(String email, String pass, String bookingID, String customerName, String customerContact, String propertyID, String propertyAddress) {
        super(email, pass);
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.propertyID = propertyID;
        this.propertyAddress = propertyAddress;
    }

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    @Override
    public String toString() {
        return "assistduringproperty{" +
                "bookingID='" + bookingID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerContact='" + customerContact + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", propertyAddress='" + propertyAddress + '\'' +
                '}';
    }
}
