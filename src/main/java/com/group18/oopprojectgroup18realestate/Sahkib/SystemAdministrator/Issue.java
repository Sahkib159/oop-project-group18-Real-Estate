package com.group18.oopprojectgroup18realestate.Sahkib.SystemAdministrator;

public class Issue {
    private String issueId;
    private String status;
    private String details;

    public Issue(String issueId, String status, String details) {
        this.issueId = issueId;
        this.status = status;
        this.details = details;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "issueId='" + issueId + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
