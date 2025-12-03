package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;
import java.time.LocalDate;

public class scheduleVisit implements Serializable {
    private String buyerName;
    private String propertyId;
    private LocalDate date;
    private String timeslot;
    private String status;

    public scheduleVisit(String buyerName, String propertyId, LocalDate date, String timeslot, String status) {
        this.buyerName = buyerName;
        this.propertyId = propertyId;
        this.date = date;
        this.timeslot = timeslot;
        this.status = status;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "scheduleVisit{" +
                "buyerName='" + buyerName + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", date=" + date +
                ", timeslot='" + timeslot + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
