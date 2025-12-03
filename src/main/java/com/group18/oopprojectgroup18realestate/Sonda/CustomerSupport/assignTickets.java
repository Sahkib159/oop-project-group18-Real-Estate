package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import com.group18.oopprojectgroup18realestate.User;




public class assignTickets {
    private String ticketID;
    private String ticketSummary;
    private String currentStatus;
    private String department;
    private String assignedUser;
    private String priority;

    public assignTickets(String ticketID, String ticketSummary, String currentStatus, String department, String assignedUser, String priority) {
        this.ticketID = ticketID;
        this.ticketSummary = ticketSummary;
        this.currentStatus = currentStatus;
        this.department = department;
        this.assignedUser = assignedUser;
        this.priority = priority;
    }

    public String getTicketID() {
        return ticketID;
    }

    public void setTicketID(String ticketID) {
        this.ticketID = ticketID;
    }

    public String getTicketSummary() {
        return ticketSummary;
    }

    public void setTicketSummary(String ticketSummary) {
        this.ticketSummary = ticketSummary;
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

    public String getAssignedUser() {
        return assignedUser;
    }

    public void setAssignedUser(String assignedUser) {
        this.assignedUser = assignedUser;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "assignTickets{" +
                "ticketID='" + ticketID + '\'' +
                ", ticketSummary='" + ticketSummary + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                ", department='" + department + '\'' +
                ", assignedUser='" + assignedUser + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
