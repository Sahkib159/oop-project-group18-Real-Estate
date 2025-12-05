package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

public class Analyzemarket {
    private String area;
    private String competetor;
    private String summary;

    public Analyzemarket(String area, String competetor, String summary) {
        this.area = area;
        this.competetor = competetor;
        this.summary = summary;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCompetetor() {
        return competetor;
    }

    public void setCompetetor(String competetor) {
        this.competetor = competetor;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Override
    public String toString() {
        return "Analyzemarket{" +
                "area='" + area + '\'' +
                ", competetor='" + competetor + '\'' +
                ", summary='" + summary + '\'' +
                '}';
    }
}
