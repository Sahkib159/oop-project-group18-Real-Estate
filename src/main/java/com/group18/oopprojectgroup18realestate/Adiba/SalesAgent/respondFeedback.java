package com.group18.oopprojectgroup18realestate.Adiba.SalesAgent;

import java.io.Serializable;

public class respondFeedback implements Serializable {
    private String feedbackId;
    private String buyerName;
    private String propertyID;
    private String feedbackMessage;
    private String response;

    public respondFeedback(String feedbackId, String buyerName, String propertyID, String feedbackMessage, String response) {
        this.feedbackId = feedbackId;
        this.buyerName = buyerName;
        this.propertyID = propertyID;
        this.feedbackMessage = feedbackMessage;
        this.response = response;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getPropertyID() {
        return propertyID;
    }

    public void setPropertyID(String propertyID) {
        this.propertyID = propertyID;
    }

    public String getFeedbackMessage() {
        return feedbackMessage;
    }

    public void setFeedbackMessage(String feedbackMessage) {
        this.feedbackMessage = feedbackMessage;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    @Override
    public String toString() {
        return "respondFeedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", buyerName='" + buyerName + '\'' +
                ", propertyID='" + propertyID + '\'' +
                ", feedbackMessage='" + feedbackMessage + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}

