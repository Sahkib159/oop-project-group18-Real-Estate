package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
import com.group18.oopprojectgroup18realestate.User;
import java.io.Serializable;

public class AssignTickets extends User implements Serializable {
    private int ticId;
    private String ticSummary;
    private String currentStatus;
    private String department;
    private String assignTo;
    private String priority;
    private String issueType;
    private String customer;
    private String assignedTo;
    private String status;

    public AssignTickets(String email, String pass, int ticId, String ticSummary, String currentStatus, String department, String assignTo, String priority, String issueType, String customer, String assignedTo, String status) {
        super(email, pass);
        this.ticId = ticId;
        this.ticSummary = ticSummary;
        this.currentStatus = currentStatus;
        this.department = department;
        this.assignTo = assignTo;
        this.priority = priority;
        this.issueType = issueType;
        this.customer = customer;
        this.assignedTo = assignedTo;
        this.status = status;
    }

    public int getTicId() {
        return ticId;
    }

    public void setTicId(int ticId) {
        this.ticId = ticId;
    }

    public String getTicSummary() {
        return ticSummary;
    }

    public void setTicSummary(String ticSummary) {
        this.ticSummary = ticSummary;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "AssignTickets{" +
                "ticId=" + ticId +
                ", ticSummary='" + ticSummary + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", department='" + department + '\'' +
                ", assignTo='" + assignTo + '\'' +
                ", priority='" + priority + '\'' +
                ", issueType='" + issueType + '\'' +
                ", customer='" + customer + '\'' +
                ", assignedTo='" + assignedTo + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
