package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;
import com.group18.oopprojectgroup18realestate.User;
import java.io.Serializable;

public class AssignTickets extends User  implements Serializable {
    private int ticId;
    private String ticSummary;
    private String currentStatus;

    public AssignTickets(String email, String pass, int ticId, String ticSummary, String currentStatus) {
        super(email, pass);
        this.ticId = ticId;
        this.ticSummary = ticSummary;
        this.currentStatus = currentStatus;
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

    @Override
    public String toString() {
        return "AssignTickets{" +
                "ticId=" + ticId +
                ", ticSummary='" + ticSummary + '\'' +
                ", currentStatus='" + currentStatus + '\'' +
                '}';
    }
}