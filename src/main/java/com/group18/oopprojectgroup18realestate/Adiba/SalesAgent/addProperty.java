package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;

public class addProperty implements Serializable {
    private String bookingId;
    private String buyerName;
    private String status;
    private String phone;
    private String email;
    private double bookingAmount;
    private double remainingBalance;
    private double installmentAmount;
    private String paymentMethod;
    private String propertyId;
    private String propertyName;
    private String location;
    private String price;
    private String size;
    private String availability;
    private String features;

    public addProperty(String bookingId, String buyerName, String status, String phone, String email, double bookingAmount, double remainingBalance, double installmentAmount, String paymentMethod, String propertyId, String propertyName, String location, String price, String size, String availability, String features) {
        this.bookingId = bookingId;
        this.buyerName = buyerName;
        this.status = status;
        this.phone = phone;
        this.email = email;
        this.bookingAmount = bookingAmount;
        this.remainingBalance = remainingBalance;
        this.installmentAmount = installmentAmount;
        this.paymentMethod = paymentMethod;
        this.propertyId = propertyId;
        this.propertyName = propertyName;
        this.location = location;
        this.price = price;
        this.size = size;
        this.availability = availability;
        this.features = features;
    }

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

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    @Override
    public String toString() {
        return "addProperty{" +
                "bookingId='" + bookingId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", status='" + status + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", bookingAmount=" + bookingAmount +
                ", remainingBalance=" + remainingBalance +
                ", installmentAmount=" + installmentAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", propertyId='" + propertyId + '\'' +
                ", propertyName='" + propertyName + '\'' +
                ", location='" + location + '\'' +
                ", price='" + price + '\'' +
                ", size='" + size + '\'' +
                ", availability='" + availability + '\'' +
                ", features='" + features + '\'' +
                '}';
    }
}










