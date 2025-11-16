package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;

public class trackBooking implements Serializable {
    private String bookingID;
    private String currentStatus;

    public trackBooking(String bookingID, String currentStatus) {
        this.bookingID = bookingID;
        this.currentStatus = currentStatus;
    }

    public String getBookingID() {
        return bookingID;
    }

    public void setBookingID(String bookingID) {
        this.bookingID = bookingID;
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
                "bookingID='" + bookingID + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}
