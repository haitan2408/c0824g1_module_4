package com.codegym.c0824g1_spring_boot.model;

import java.time.LocalDate;

public class Classroom {
    private Integer id;
    private String nameClass;
    private LocalDate startDate;
    private LocalDate endDate;

    public Classroom() {
    }

    public Classroom(Integer id, String nameClass, LocalDate startDate, LocalDate endDate) {
        this.id = id;
        this.nameClass = nameClass;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameClass() {
        return nameClass;
    }

    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
