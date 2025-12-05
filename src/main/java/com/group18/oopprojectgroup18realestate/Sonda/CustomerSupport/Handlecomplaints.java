package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
import com.group18.oopprojectgroup18realestate.User;

import java.io.Serializable;
import java.time.LocalDate;


public class Handlecomplaints extends User implements Serializable {
    private int complntId;
    private String customer;
    private String complaintType;
    private String status;
    private LocalDate date;

    public Handlecomplaints(String email, String pass, int complntId, String customer, String complaintType, String status, LocalDate date) {
        super(email, pass);
        this.complntId = complntId;
        this.customer = customer;
        this.complaintType = complaintType;
        this.status = status;
        this.date = date;
    }

    public int getComplntId() {
        return complntId;
    }

    public void setComplntId(int complntId) {
        this.complntId = complntId;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(String complaintType) {
        this.complaintType = complaintType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Handlecomplaints{" +
                "complntId=" + complntId +
                ", customer='" + customer + '\'' +
                ", complaintType='" + complaintType + '\'' +
                ", status='" + status + '\'' +
                ", date=" + date +
                '}';
    }
}
