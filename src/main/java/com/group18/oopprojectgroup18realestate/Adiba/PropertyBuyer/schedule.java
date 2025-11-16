package com.group18.oopprojectgroup18realestate.Adiba.PropertyBuyer;

import java.io.Serializable;
import java.time.LocalDate;

public class schedule implements Serializable {
    private String selectTime;
    private LocalDate selectDate;


    public schedule(String selectTime, LocalDate selectDate) {
        this.selectTime = selectTime;
        this.selectDate = selectDate;
    }

    public String getSelectTime() {
        return selectTime;
    }

    public void setSelectTime(String selectTime) {
        this.selectTime = selectTime;
    }

    public LocalDate getSelectDate() {
        return selectDate;
    }

    public void setSelectDate(LocalDate selectDate) {
        this.selectDate = selectDate;
    }

    @Override
    public String toString() {
        return "schedule{" +
                "selectTime='" + selectTime + '\'' +
                ", selectDate=" + selectDate +
                '}';
    }
}
