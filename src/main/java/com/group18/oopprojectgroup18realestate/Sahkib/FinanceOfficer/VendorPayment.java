package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

public class VendorPayment {
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

    public void setVendorId(String vendorId) {
        this.vendorId = vendorId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "VendorPayment{" +
                "vendorId='" + vendorId + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
