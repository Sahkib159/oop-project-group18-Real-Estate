package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import java.time.LocalDate;

public class Generatereports {
    private LocalDate startdate;
    private LocalDate enddate;
    private int views;
    private int clicks;
    private int leads;

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getLeads() {
        return leads;
    }

    public void setLeads(int leads) {
        this.leads = leads;
    }

    @Override
    public String toString() {
        return "Generatereports{" +
                "startdate=" + startdate +
                ", enddate=" + enddate +
                ", views=" + views +
                ", clicks=" + clicks +
                ", leads=" + leads +
                '}';
    }

}
