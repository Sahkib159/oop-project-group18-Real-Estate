package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

public class Managesupporttickets {
    private int ticId;
    private String username;
    private String priority;
    private String ticstatus;

    public Managesupporttickets(int ticId, String username, String priority, String ticstatus) {
        this.ticId = ticId;
        this.username = username;
        this.priority = priority;
        this.ticstatus = ticstatus;
    }

    public int getTicId() {
        return ticId;
    }

    public void setTicId(int ticId) {
        this.ticId = ticId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTicstatus() {
        return ticstatus;
    }

    public void setTicstatus(String ticstatus) {
        this.ticstatus = ticstatus;
    }

    @Override
    public String toString() {
        return "Managesupporttickets{" +
                "ticId=" + ticId +
                ", username='" + username + '\'' +
                ", priority='" + priority + '\'' +
                ", ticstatus='" + ticstatus + '\'' +
                '}';
    }
}
