package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;

public class inquirySupport implements Serializable {
    private int inquiryID;
    private int tenantID;
    private String message;

    public inquirySupport(int tenantID, int inquiryID, String message) {
        this.tenantID = tenantID;
        this.inquiryID = inquiryID;
        this.message = message;
    }

    public int getInquiryID() {
        return inquiryID;
    }

    public void setInquiryID(int inquiryID) {
        this.inquiryID = inquiryID;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "inquirySupport{" +
                "inquiryID=" + inquiryID +
                ", tenantID=" + tenantID +
                ", message='" + message + '\'' +
                '}';
    }
}
