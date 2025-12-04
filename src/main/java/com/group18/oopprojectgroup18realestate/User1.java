package com.group18.oopprojectgroup18realestate;

import java.io.Serializable;
import java.util.Objects;

public class User1 implements Serializable {
    private String username;
    private String password;
    private String role;

    public User1(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
//    public User1 login(String username, String password) {
//        if (Objects.equals(this.getUsername(), username) && Objects.equals(this.getPassword(), password)) {
//            return this;
//        }
//        else {
//            return null ;
//        }
//    }
//
//    public boolean resetPassword(String oldPassword, String newPassword) {
//        if (Objects.equals(this.getPassword(), oldPassword)) {
//            this.setPassword(newPassword);
//            return true ;
//        }
//        return false ;
//    }
}
