package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

import java.io.Serializable;

public class LogEntry implements Serializable {

    private String date;      // YYYY-MM-DD
    private String message;

    public LogEntry(String date, String message) {
        this.date = date;
        this.message = message;
    }

    public String getDate() {
        return date;
    }

    public String getMessage() {
        return message;
    }
}
