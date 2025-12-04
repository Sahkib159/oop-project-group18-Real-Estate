package com.group18.oopprojectgroup18realestate;

import java.io.Serializable;

public class VendorPayment implements Serializable {

    private String vendorId;
    private double amount;
    private String date;

    public VendorPayment(String vendorId, double amount, String date) {
        this.vendorId = vendorId;
        this.amount = amount;
        this.date = date;
    }

    public String getVendorId() {
        return vendorId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
