package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;
import java.time.LocalDate;

public class lease implements Serializable {
    private int leaseID;
    private int tenantID;
    private int propertyID;
    private LocalDate startDate;
    private LocalDate endDate;
    private double rentAmount;
    private String status;
    private String propertyType;

    public lease(int leaseID, int tenantID, int propertyID, LocalDate startDate, LocalDate endDate, double rentAmount, String status, String propertyType) {
        this.leaseID = leaseID;
        this.tenantID = tenantID;
        this.propertyID = propertyID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rentAmount = rentAmount;
        this.status = status;
        this.propertyType = propertyType;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
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

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public void setRentAmount(double rentAmount) {
        this.rentAmount = rentAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    @Override
    public String toString() {
        return "lease{" +
                "leaseID=" + leaseID +
                ", tenantID=" + tenantID +
                ", propertyID=" + propertyID +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", rentAmount=" + rentAmount +
                ", status='" + status + '\'' +
                ", propertyType='" + propertyType + '\'' +
                '}';
    }
}
