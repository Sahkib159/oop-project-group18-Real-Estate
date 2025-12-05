package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;

public class bookings implements Serializable {
    private String bookingId;
    private String buyerName;
    private String propertyId;
    private String status;
    private String phone;
    private String email;
    private String property;
    private double bookingAmount;
    private double remainingBalance;
    private double installmentAmount;
    private String paymentMethod;

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public double getBookingAmount() {
        return bookingAmount;
    }

    public void setBookingAmount(double bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public double getRemainingBalance() {
        return remainingBalance;
    }

    public void setRemainingBalance(double remainingBalance) {
        this.remainingBalance = remainingBalance;
    }

    public double getInstallmentAmount() {
        return installmentAmount;
    }

    public void setInstallmentAmount(double installmentAmount) {
        this.installmentAmount = installmentAmount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public String toString() {
        return "bookings{" +
                "bookingId='" + bookingId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", property='" + property + '\'' +
                ", bookingAmount=" + bookingAmount +
                ", remainingBalance=" + remainingBalance +
                ", installmentAmount=" + installmentAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                '}';
    }

    public bookings(String bookingId, String buyerName, String propertyId, String status, String phone, String email, String property, double bookingAmount, double remainingBalance, double installmentAmount, String paymentMethod) {
        this.bookingId = bookingId;
        this.buyerName = buyerName;
        this.propertyId = propertyId;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.property = property;
        this.bookingAmount = bookingAmount;
        this.remainingBalance = remainingBalance;
        this.installmentAmount = installmentAmount;
        this.paymentMethod = paymentMethod;




    }
}
