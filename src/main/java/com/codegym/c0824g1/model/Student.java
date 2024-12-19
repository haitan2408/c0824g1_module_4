package com.codegym.c0824g1.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "INT")
    private Integer id;

    @Column(name = "name_student", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "email", columnDefinition = "VARCHAR(100)", nullable = false)
    private String email;

    @Column(name = "score", columnDefinition = "DOUBLE")
    private Float point;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dob;

    @Column(name = "id_class")
    private Integer idClass;

    public Student() {
    }

    public Student(Integer id, String name, String email, Float point, LocalDate dob, Integer idClass) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.point = point;
        this.dob = dob;
        this.idClass = idClass;
    }

    public Student(String nameStudent, String email, Float point, String dob, String idClass) {
        this.name = nameStudent;
        this.email = email;
        this.point = point;
        this.dob = LocalDate.parse(dob);
        this.idClass = Integer.parseInt(idClass);
    }

//    public Student(String name, String email, Float point, LocalDate dob, Integer idClass) {
//        this.name = name;
//        this.email = email;
//        this.point = point;
//        this.dob = dob;
//        this.idClass = idClass;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Float getPoint() {
        return point;
    }

    public void setPoint(Float point) {
        this.point = point;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getIdClass() {
        return idClass;
    }

    public void setIdClass(Integer idClass) {
        this.idClass = idClass;
    }
}
