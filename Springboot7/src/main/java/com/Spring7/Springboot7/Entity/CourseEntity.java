package com.Spring7.Springboot7.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Table
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String coursename;
    private String studentname;
    private Double Fee;

    public CourseEntity(Long id, String coursename, String studentname, Double fee) {
        this.id = id;
        this.coursename = coursename;
        this.studentname = studentname;
        Fee = fee;
    }
    public CourseEntity(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getStudentname() {
        return studentname;
    }

    public void setStudentname(String studentname) {
        this.studentname = studentname;
    }

    public Double getFee() {
        return Fee;
    }

    public void setFee(Double fee) {
        Fee = fee;
    }
}
