package com.group18.oopprojectgroup18realestate;

import java.io.Serializable;

public class SalaryRecord implements Serializable {

    private String employeeId;
    private double amount;
    private String date;

    public SalaryRecord(String employeeId, double amount, String date) {
        this.employeeId = employeeId;
        this.amount = amount;
        this.date = date;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }
}
