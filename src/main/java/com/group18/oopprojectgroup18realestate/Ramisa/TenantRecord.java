package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;
import java.time.LocalDate;

public class TenantRecord implements Serializable {
    private int applicationId;
    private int tenantID;
    private String tenantName;
    private String email;
    private int propertyID;
    private String location;
    private double budget;
    private LocalDate dateApplied;
    private LocalDate leaseStartDate;
    private LocalDate leaseEndDate;
    private int leaseID;
    private String leaseType;
    private String status;

    public TenantRecord(int applicationId, int tenantID, String tenantName, String email, int propertyID, String location, double budget, LocalDate dateApplied, LocalDate leaseStartDate, LocalDate leaseEndDate, int leaseID, String leaseType, String status) {
        this.applicationId = applicationId;
        this.tenantID = tenantID;
        this.tenantName = tenantName;
        this.email = email;
        this.propertyID = propertyID;
        this.location = location;
        this.budget = budget;
        this.dateApplied = dateApplied;
        this.leaseStartDate = leaseStartDate;
        this.leaseEndDate = leaseEndDate;
        this.leaseID = leaseID;
        this.leaseType = leaseType;
        this.status = status;
    }

    public int getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(int applicationId) {
        this.applicationId = applicationId;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public LocalDate getDateApplied() {
        return dateApplied;
    }

    public void setDateApplied(LocalDate dateApplied) {
        this.dateApplied = dateApplied;
    }

    public LocalDate getLeaseStartDate() {
        return leaseStartDate;
    }

    public void setLeaseStartDate(LocalDate leaseStartDate) {
        this.leaseStartDate = leaseStartDate;
    }

    public LocalDate getLeaseEndDate() {
        return leaseEndDate;
    }

    public void setLeaseEndDate(LocalDate leaseEndDate) {
        this.leaseEndDate = leaseEndDate;
    }

    public int getLeaseID() {
        return leaseID;
    }

    public void setLeaseID(int leaseID) {
        this.leaseID = leaseID;
    }

    public String getLeaseType() {
        return leaseType;
    }

    public void setLeaseType(String leaseType) {
        this.leaseType = leaseType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "TenantRecord{" +
                "applicationId=" + applicationId +
                ", tenantID=" + tenantID +
                ", tenantName='" + tenantName + '\'' +
                ", email='" + email + '\'' +
                ", propertyID=" + propertyID +
                ", location='" + location + '\'' +
                ", budget=" + budget +
                ", dateApplied=" + dateApplied +
                ", leaseStartDate=" + leaseStartDate +
                ", leaseEndDate=" + leaseEndDate +
                ", leaseID=" + leaseID +
                ", leaseType='" + leaseType + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
