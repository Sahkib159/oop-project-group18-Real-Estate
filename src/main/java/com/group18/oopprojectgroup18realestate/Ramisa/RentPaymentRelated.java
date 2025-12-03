package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;
import java.time.LocalDate;

public class RentPaymentRelated implements Serializable {

    private String year;
    private int month;
    private int tenantID;
    private int propertyID;
    private int paymentID;
    private int reportID;
    private  double amount;
    private double paid;
    private double totalCollected;
    private double pending;
    private double expected;
    private String  Status;
    private String paymentMethod;
    private LocalDate date;

    public RentPaymentRelated(String year, int month, int tenantID, int propertyID, int paymentID, int reportID, double amount, double paid, double totalCollected, double pending, double expected, String status, String paymentMethod, LocalDate date) {
        this.year = year;
        this.month = month;
        this.tenantID = tenantID;
        this.propertyID = propertyID;
        this.paymentID = paymentID;
        this.reportID = reportID;
        this.amount = amount;
        this.paid = paid;
        this.totalCollected = totalCollected;
        this.pending = pending;
        this.expected = expected;
        Status = status;
        this.paymentMethod = paymentMethod;
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public double getTotalCollected() {
        return totalCollected;
    }

    public void setTotalCollected(double totalCollected) {
        this.totalCollected = totalCollected;
    }

    public double getPending() {
        return pending;
    }

    public void setPending(double pending) {
        this.pending = pending;
    }

    public double getExpected() {
        return expected;
    }

    public void setExpected(double expected) {
        this.expected = expected;
    }

    public double getPaid() {
        return paid;
    }

    public void setPaid(double paid) {
        this.paid = paid;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getReportID() {
        return reportID;
    }

    public void setReportID(int reportID) {
        this.reportID = reportID;
    }

    public int getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(int paymentID) {
        this.paymentID = paymentID;
    }

    public int getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(int propertyID) {
        this.propertyID = propertyID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "RentReport{" +
                "year='" + year + '\'' +
                ", month=" + month +
                ", tenantID=" + tenantID +
                ", propertyID=" + propertyID +
                ", paymentID=" + paymentID +
                ", reportID=" + reportID +
                ", amount=" + amount +
                ", paid=" + paid +
                ", totalCollected=" + totalCollected +
                ", pending=" + pending +
                ", expected=" + expected +
                ", Status='" + Status + '\'' +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", date=" + date +
                '}';
    }
}
