package com.group18.oopprojectgroup18realestate;

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

    public void setDate(String date) {
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "date='" + date + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
