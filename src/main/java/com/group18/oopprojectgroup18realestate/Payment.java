package com.group18.oopprojectgroup18realestate;

import java.io.Serializable;

public class Payment implements Serializable {
    private String clientId;
    private double amount;
    private String date;

    public Payment(String clientId, double amount, String date) {
        this.clientId = clientId;
        this.amount = amount;
        this.date = date;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
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
        return "Payment{" +
                "clientId='" + clientId + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
