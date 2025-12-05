package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

public class Createcampaigns {
    private String title;
    private String targetAudience;
    private String budget;
    private String startDate;
    private String endDate;

    public Createcampaigns(String title, String targetAudience, String budget, String startDate, String endDate) {
        this.title = title;
        this.targetAudience = targetAudience;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Createcampaigns{" +
                "title='" + title + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", budget='" + budget + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
