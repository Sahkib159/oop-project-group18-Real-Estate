package com.group18.oopprojectgroup18realestate.Ramisa;

import java.io.Serializable;

public class tenantProfile implements Serializable {
    private int tenantID;
    private String name;
    private String email;
    private String phone;
    private String location;

    public tenantProfile(int tenantID, String name, String email, String phone, String location) {
        this.tenantID = tenantID;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.location = location;
    }

    public int getTenantID() {
        return tenantID;
    }

    public void setTenantID(int tenantID) {
        this.tenantID = tenantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "tenantProfile{" +
                "tenantID=" + tenantID +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
