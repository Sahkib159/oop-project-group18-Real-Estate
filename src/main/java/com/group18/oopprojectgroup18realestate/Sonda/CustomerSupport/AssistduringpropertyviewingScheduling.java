package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

public class AssistduringpropertyviewingScheduling {

    private String bookingID;
    private String customerName;
    private String customerContact;

    private String propertyID;
    private String propertyAddress;

    public AssistduringpropertyviewingScheduling(String bookingID, String customerName, String customerContact, String propertyID, String propertyAddress) {
        this.bookingID = bookingID;
        this.customerName = customerName;
        this.customerContact = customerContact;
        this.propertyID = propertyID;
        this.propertyAddress = propertyAddress;
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

    public String getCustomerContact() {
        return customerContact;
    }

    public void setCustomerContact(String customerContact) {
        this.customerContact = customerContact;
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
        return "AssistduringpropertyviewingScheduling{" +
                "bookingID='" + bookingID + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerContact='" + customerContact + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", propertyAddress='" + propertyAddress + '\'' +
                '}';
    }
}
