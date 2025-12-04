package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;

public class Inquiries implements Serializable {
    private String inquiryId;
    private String buyerName;
    private String property;
    private String message;
    private String response;

    public Inquiries(String inquiryId, String buyerName, String property, String message, String response) {
        this.inquiryId = inquiryId;
        this.buyerName = buyerName;
        this.property = property;
        this.message = message;
        this.response = response;
    }

    public String getInquiryId() {
        return inquiryId;
    }

    public void setInquiryId(String inquiryId) {
        this.inquiryId = inquiryId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getProperty() {
        return property;
    }

    public void setProperty(String property) {
        this.property = property;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "Inquiries{" +
                "inquiryId='" + inquiryId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", property='" + property + '\'' +
                ", message='" + message + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
