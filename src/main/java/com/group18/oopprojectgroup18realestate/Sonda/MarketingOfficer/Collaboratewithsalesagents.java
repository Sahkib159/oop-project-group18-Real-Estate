package com.group18.oopprojectgroup18realestate.Sonda.MarketingOfficer;

import java.time.LocalDate;

public class Collaboratewithsalesagents {
    private String agent;
    private String material;
    private LocalDate date;

    public Collaboratewithsalesagents(String agent, String material, LocalDate date) {
        this.agent = agent;
        this.material = material;
        this.date = date;
    }

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Collaboratewithsalesagents{" +
                "agent='" + agent + '\'' +
                ", material='" + material + '\'' +
                ", date=" + date +
                '}';
    }
}
