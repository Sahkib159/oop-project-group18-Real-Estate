package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
import com.group18.oopprojectgroup18realestate.User;
import javafx.scene.control.DatePicker;

import java.io.Serializable;
import java.time.LocalDate;

public class Generatesupportreports extends User implements Serializable {
    private LocalDate date;
    private String ticketId;
    private String type;
    private String customer;
    private String status;

    public Generatesupportreports(String email, String pass, LocalDate date, String ticketId, String type, String customer, String status) {
        super(email, pass);
        this.date = date;
        this.ticketId = ticketId;
        this.type = type;
        this.customer = customer;
        this.status = status;
    }


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Generatesupportreports{" +
                "date=" + date +
                ", ticketId='" + ticketId + '\'' +
                ", type='" + type + '\'' +
                ", customer='" + customer + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
