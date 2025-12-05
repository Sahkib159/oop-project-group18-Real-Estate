package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

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

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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
        return "SalaryRecord{" +
                "employeeId='" + employeeId + '\'' +
                ", amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }
}
