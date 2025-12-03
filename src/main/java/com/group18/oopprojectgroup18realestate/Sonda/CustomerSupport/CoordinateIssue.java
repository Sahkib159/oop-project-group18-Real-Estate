package com.group18.oopprojectgroup18realestate.Sonda.CustomerSupport;

import com.group18.oopprojectgroup18realestate.User;

import java.io.Serializable;

public class CoordinateIssue extends User implements Serializable {
    private int cusId;
    private String cusName;
    private String des;
    private String issuType;
    private String routingPri;
    private String delDep;

    public CoordinateIssue(String email, String pass, int cusId, String cusName, String des, String issuType, String routingPri, String delDep) {
        super(email, pass);
        this.cusId = cusId;
        this.cusName = cusName;
        this.des = des;
        this.issuType = issuType;
        this.routingPri = routingPri;
        this.delDep = delDep;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getIssuType() {
        return issuType;
    }

    public void setIssuType(String issuType) {
        this.issuType = issuType;
    }

    public String getRoutingPri() {
        return routingPri;
    }

    public void setRoutingPri(String routingPri) {
        this.routingPri = routingPri;
    }

    public String getDelDep() {
        return delDep;
    }

    public void setDelDep(String delDep) {
        this.delDep = delDep;
    }

    @Override
    public String toString() {
        return "CoordinateIssue{" +
                "cusId=" + cusId +
                ", cusName='" + cusName + '\'' +
                ", des='" + des + '\'' +
                ", issuType='" + issuType + '\'' +
                ", routingPri='" + routingPri + '\'' +
                ", delDep='" + delDep + '\'' +
                '}';
    }
}
