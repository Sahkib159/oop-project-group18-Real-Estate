package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;
import java.time.LocalDate;

public class MaintenanceRequest implements Serializable {
    private int requestID;
    private int tenantID;
    private String issue;
    private LocalDate requestDate;
    private String status;
    private String managerNotes;
    private int propertyID;

    //for tenant

    public MaintenanceRequest(int requestID, int tenantID, String issue, String status, LocalDate requestDate, int propertyID) {
        this.requestID = requestID;
        this.tenantID = tenantID;
        this.issue = issue;
        this.status = status;
        this.requestDate = requestDate;
        this.managerNotes = "";
        this.propertyID = propertyID;
    }

    //for manager with manager notes

    public MaintenanceRequest(int requestID, int tenantID, LocalDate requestDate, String issue, String status, String managerNotes, int propertyID) {
        this.requestID = requestID;
        this.tenantID = tenantID;
        this.requestDate = requestDate;
        this.issue = issue;
        this.status = status;
        this.managerNotes = managerNotes;
        this.propertyID = propertyID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public int getRequestID() {
        return requestID;
    }

    public void setRequestID(int requestID) {
        this.requestID = requestID;
    }

    public String getIssue() {
        return issue;
    }

    public void setIssue(String issue) {
        this.issue = issue;
    }

    public LocalDate getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(LocalDate requestDate) {
        this.requestDate = requestDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getManagerNotes() {
        return managerNotes;
    }

    public void setManagerNotes(String managerNotes) {
        this.managerNotes = managerNotes;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" +
                "requestID=" + requestID +
                ", tenantID=" + tenantID +
                ", issue='" + issue + '\'' +
                ", requestDate=" + requestDate +
                ", status='" + status + '\'' +
                ", managerNotes='" + managerNotes + '\'' +
                ", propertyID=" + propertyID +
                '}';
    }
    //custom methods

}
