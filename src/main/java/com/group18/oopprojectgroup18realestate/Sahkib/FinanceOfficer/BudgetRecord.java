package com.group18.oopprojectgroup18realestate.Sahkib.FinanceOfficer;

import java.io.Serializable;

public class BudgetRecord implements Serializable {

    private String department;
    private double amount;
    private String status;

    public BudgetRecord(String department, double amount, String status) {
        this.department = department;
        this.amount = amount;
        this.status = status;
    }

    // Getters
    public String getDepartment() {
        return department;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setDepartment(String department) {
        this.department = department;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BudgetRecord{" +
                "department='" + department + '\'' +
                ", amount=" + amount +
                ", status='" + status + '\'' +
                '}';
    }
}
