package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;
import java.time.LocalDate;

public class PaymentData implements Serializable {
    private int paymentID;
    private int tenantID;
    private String propertyID;
    private double amount;
    private LocalDate date;
    private String method;
    private String status;

    public PaymentData(int paymentID, int tenantID, String propertyID, double amount, LocalDate date, String status, String method) {
        this.paymentID = paymentID;
        this.tenantID = tenantID;
        this.propertyID = propertyID;
        this.amount = amount;
        this.date = date;
        this.status = status;
        this.method = method;

    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PaymentData{" +
                "paymentID=" + paymentID +
                ", tenantID=" + tenantID +
                ", propertyID='" + propertyID + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                ", method='" + method + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
